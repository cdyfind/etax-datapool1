package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.entity.BillInspectionData;
import com.aisino.entity.BillInspectionDataGoods;
import com.aisino.entity.TestData;
import com.aisino.enums.BillSourceEnum;
import com.aisino.service.BillInspectionDataGoodsService;
import com.aisino.service.BillInspectionDataService;
import com.aisino.service.DataAnalysisService;
import com.aisino.util.CheckObjectNullUtil;
import com.aisino.util.ThreadPoolUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
@Component
public class BillInspectionDataAnalysisService implements DataAnalysisService {

    @Resource
    private IdGeneratorSnowflake snowflake;

    @Resource
    private BillInspectionDataService billInspectionDataService;

    @Resource
    private BillInspectionDataGoodsService goodsService;


    @Override
    public String getDataType() {
        return BillSourceEnum.chayan.name();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dataAnalysis(JSONObject datagram, String invoiceLogId) {
        log.info("解析查验数据 ==>datagram："+datagram.toJSONString());
        BillInspectionData billInspectionData = JSON.parseObject(datagram.toJSONString(), BillInspectionData.class);
        try {
            boolean fieldsNull = CheckObjectNullUtil.allFieldsNull(billInspectionData);
            if (fieldsNull){
                return;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ThreadPoolUtils.execute(()-> {//使用线程池
            Integer count = this.countInvoiceCode(billInspectionData);
            if (count == 0) {
                this.addHandle(billInspectionData, invoiceLogId, datagram);
            } else {
                //先清除旧数据
                this.deleteHandle(billInspectionData);
                this.addHandle(billInspectionData, invoiceLogId, datagram);
            }
        });
    }

    /**
     *  计算发票号数量
     * @param data
     * @return
     */
    public Integer countInvoiceCode(BillInspectionData data){
        String code = data.getInvoiceCode();
        String no = data.getInvoiceNo();
        LambdaQueryWrapper<BillInspectionData> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BillInspectionData::getInvoiceCode, code)
                .eq(BillInspectionData::getInvoiceNo,no);
        return billInspectionDataService.count(wrapper);
    }

    /**
     *  添加处理操作
     */
    @Transactional(rollbackFor = Exception.class)
    public void addHandle(BillInspectionData billInspectionData,String invoiceLogId,JSONObject datagram){
        billInspectionData.setInvoiceLogId(invoiceLogId);
        BillInspectionData data = billInspectionDataService.saveBillInspectionData(billInspectionData);
        List<BillInspectionDataGoods> goodsList = Optional.ofNullable(datagram.getJSONArray("detailList"))
                .filter(CollectionUtils::isNotEmpty)
                .map(goods -> JSON.parseArray(goods.toJSONString(), BillInspectionDataGoods.class))
                .orElse(Collections.emptyList())
                .stream()
                .peek(gl -> {
                    gl.setId(snowflake.snowflakeId().toString());
                    gl.setInspectionDataId(data.getId());
                    gl.setInvoiceLogId(invoiceLogId);
                })
                .collect(Collectors.toList());
        goodsService.saveBatch(goodsList);
    }

    /**
     *  删除处理操作
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteHandle(BillInspectionData billInspectionData){
        String code = billInspectionData.getInvoiceCode();
        String no = billInspectionData.getInvoiceNo();
        LambdaQueryWrapper<BillInspectionData> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BillInspectionData::getInvoiceCode, code)
                .eq(BillInspectionData::getInvoiceNo, no);
        List<BillInspectionData> dataList = billInspectionDataService.list(wrapper);
        dataList.stream().forEach(data -> {
            String dataId = data.getId();
            LambdaQueryWrapper <BillInspectionDataGoods> goodsWrapper = new LambdaQueryWrapper<>();
            goodsWrapper.eq(BillInspectionDataGoods::getInspectionDataId, dataId);
            goodsService.remove(goodsWrapper);
            billInspectionDataService.removeById(dataId);
        });
    }
}


