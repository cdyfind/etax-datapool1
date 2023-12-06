package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.entity.PlatformPurchaseSalesGoods;
import com.aisino.entity.TaxPurchaseSales;
import com.aisino.entity.TaxPurchaseSalesDetails;
import com.aisino.enums.BillSourceEnum;
import com.aisino.service.DataAnalysisService;
import com.aisino.service.TaxPurchaseSalesDetailsService;
import com.aisino.service.TaxPurchaseSalesService;
import com.aisino.util.CheckObjectNullUtil;
import com.aisino.util.ThreadPoolUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Component
public class TaxPurchaseSalesDataAnalysisService implements DataAnalysisService {
    @Resource
    private IdGeneratorSnowflake snowflake;
    @Resource
    private TaxPurchaseSalesService taxPurchaseSalesService;

    @Resource
    private TaxPurchaseSalesDetailsService taxPurchaseSalesDetailsService;
    @Override
    public String getDataType() {
        return BillSourceEnum.jinsi.name();
    }
//    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dataAnalysis(JSONObject datagram, String invoiceLogId) {
        log.info("解析金四数据==>datagram"+datagram.toJSONString());
        JSONArray invoices = datagram.getJSONArray("invoices");
        if (invoices == null || invoices.size() == 0) {
            return;
        }
        List<TaxPurchaseSales> salesList = JSON.parseArray(invoices.toJSONString(), TaxPurchaseSales.class);
        //多线程实现
        for(TaxPurchaseSales lis:salesList){
            ThreadPoolUtils.execute(()->{//使用线程池
                this.insertInvoice(datagram, invoiceLogId, lis);
            });
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertInvoice(JSONObject datagram, String invoiceLogId, TaxPurchaseSales lis) {
        Integer countQdfpdm = this.countQdfpdm(lis);
        if (countQdfpdm == 0){
            this.addTaxPurchaseSales(lis, invoiceLogId, datagram);
        }else {
            this.deleteTaxPurchaseSales(lis);
            this.addTaxPurchaseSales(lis, invoiceLogId, datagram);
        }
    }

    /**
     *  统计发票号
     * @param sales
     * @return
     */
    public Integer countQdfpdm(TaxPurchaseSales sales) {
        String qdfphm = sales.getQdfphm();
        String fpdm = sales.getFpdm();
        String fphm = sales.getFphm();
        LambdaQueryWrapper<TaxPurchaseSales> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TaxPurchaseSales::getQdfphm,qdfphm)
                .eq(TaxPurchaseSales::getFpdm,fpdm)
                .eq(TaxPurchaseSales::getFphm,fphm);
        return taxPurchaseSalesService.count(wrapper);
    }
    /**
     *  添加处理操作
     */
    @Transactional(rollbackFor = Exception.class)
    public void addTaxPurchaseSales(TaxPurchaseSales taxPurchaseSales,String invoiceLogId,JSONObject datagram){//这块为什么没有做添加?
        taxPurchaseSales.setInvoiceLogId(invoiceLogId);
        TaxPurchaseSales sales = taxPurchaseSalesService.saveTax(taxPurchaseSales);
        List<TaxPurchaseSalesDetails> detailesList = Optional.ofNullable(sales.getDetailes())
                .filter(CollectionUtils::isNotEmpty)
                .map(detailes -> JSON.parseArray(detailes.toJSONString(), TaxPurchaseSalesDetails.class))
                .orElse(Collections.emptyList())
                .stream()
                .peek(dl -> {
                    dl.setId(snowflake.snowflakeId().toString());
                    dl.setTaxPurchaseSaleId(sales.getId());
                    dl.setInvoiceLogId(invoiceLogId);
                }).collect(Collectors.toList());
        taxPurchaseSalesDetailsService.saveBatch(detailesList);
    }
    /**
     *  删除处理操作
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaxPurchaseSales(TaxPurchaseSales sales){
        String qdfphm = sales.getQdfphm();
        String fpdm = sales.getFpdm();
        String fphm = sales.getFphm();
        LambdaQueryWrapper<TaxPurchaseSales> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TaxPurchaseSales::getQdfphm,qdfphm)
                .eq(TaxPurchaseSales::getFpdm,fpdm)
                .eq(TaxPurchaseSales::getFphm,fphm);
        List<TaxPurchaseSales> salesList = taxPurchaseSalesService.list(wrapper);
        salesList.stream().forEach(purchaseSales -> {
            String salesId = purchaseSales.getId();
            LambdaQueryWrapper<TaxPurchaseSalesDetails> detailWrapper = new LambdaQueryWrapper<>();
            detailWrapper.eq(TaxPurchaseSalesDetails::getTaxPurchaseSaleId,salesId);
            taxPurchaseSalesDetailsService.remove(detailWrapper);
            taxPurchaseSalesService.removeById(salesId);
        });
    }
}
