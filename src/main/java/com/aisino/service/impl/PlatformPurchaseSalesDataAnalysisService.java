package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.entity.InvoiceLog;
import com.aisino.entity.PlatformPurchaseSales;
import com.aisino.entity.PlatformPurchaseSalesGoods;
import com.aisino.enums.BillSourceEnum;
import com.aisino.service.DataAnalysisService;
import com.aisino.service.PlatformPurchaseSalesGoodsService;
import com.aisino.service.PlatformPurchaseSalesService;
import com.aisino.util.CheckObjectNullUtil;
import com.aisino.util.ThreadPoolUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Component
public class PlatformPurchaseSalesDataAnalysisService implements DataAnalysisService {

    @Resource
    private IdGeneratorSnowflake snowflake;

    @Resource
    private PlatformPurchaseSalesService platformPurchaseSalesService;

    @Resource
    private PlatformPurchaseSalesGoodsService platformPurchaseSalesGoodsService;

    @Override
    public String getDataType() {
        return BillSourceEnum.jinsan.name();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dataAnalysis(JSONObject data, String invoiceLogId) {
        log.info("解析金三数据 ==>datagram"+data.toJSONString());
        String fplx = data.getString("fplx");
        JSONObject datagram = data.getJSONObject("datagram");
        JSONArray invoices = datagram.getJSONArray("invoices");
        if (invoices == null || invoices.size() == 0) {
            return;
        }
        List<PlatformPurchaseSales> salesList = JSON.parseArray(invoices.toJSONString(), PlatformPurchaseSales.class);
        for (PlatformPurchaseSales lis:salesList) {

            lis.setFplx(fplx);

            ThreadPoolUtils.execute(()->{//使用线程池
                Integer countQdfpdm = this.countFpdm(lis);
                if (countQdfpdm == 0){
                    this.addPlatformPurchaseSales(lis,invoiceLogId,datagram);
                }else {
                    this.dedelePlatformPurchaseSales(lis);
                    this.addPlatformPurchaseSales(lis,invoiceLogId,datagram);
                }
            });
        }
    }

    /**
     *  统计发票号
     * @param sales
     * @return
     */
    public Integer countFpdm(PlatformPurchaseSales sales) {
        String fpdm = sales.getFpdm();
        String fphm = sales.getFphm();
        LambdaQueryWrapper<PlatformPurchaseSales> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlatformPurchaseSales::getFpdm,fpdm)
                .eq(PlatformPurchaseSales::getFphm, fphm);
        return platformPurchaseSalesService.count(wrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addPlatformPurchaseSales(PlatformPurchaseSales platformPurchaseSales, String invoiceLogId, JSONObject datagram) {
        platformPurchaseSales.setInvoiceLogId(invoiceLogId);
        PlatformPurchaseSales sales = platformPurchaseSalesService.savePlatformPurchaseSalesS(platformPurchaseSales);
        List<PlatformPurchaseSalesGoods> goodsList = Optional.ofNullable(sales.getGoods())
                .filter(CollectionUtils::isNotEmpty)
                .map(goods -> JSON.parseArray(goods.toJSONString(), PlatformPurchaseSalesGoods.class))
                .orElse(Collections.emptyList())
                .stream()
                .peek(gl -> {
                    gl.setId(snowflake.snowflakeId().toString());
                    gl.setPlatformPurchaseSalesId(sales.getId());
                    gl.setInvoiceLogId(invoiceLogId);
                }).collect(Collectors.toList());
        platformPurchaseSalesGoodsService.saveBatch(goodsList);
    }

    @Transactional(rollbackFor = Exception.class)
    public void dedelePlatformPurchaseSales(PlatformPurchaseSales sales){
        String fpdm = sales.getFpdm();
        String fphm = sales.getFphm();
        LambdaQueryWrapper<PlatformPurchaseSales> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlatformPurchaseSales::getFpdm,fpdm)
                .eq(PlatformPurchaseSales::getFphm, fphm);
        List<PlatformPurchaseSales> salesList = platformPurchaseSalesService.list(wrapper);
        salesList.stream().forEach(purchaseSales -> {
            String salesId = purchaseSales.getId();
            LambdaQueryWrapper<PlatformPurchaseSalesGoods> goodsWrapper = new LambdaQueryWrapper<>();
            goodsWrapper.eq(PlatformPurchaseSalesGoods::getPlatformPurchaseSalesId, salesId);
            platformPurchaseSalesGoodsService.remove(goodsWrapper);
            platformPurchaseSalesService.removeById(salesId);
        });
    }

}
