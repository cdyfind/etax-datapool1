package com.aisino.base;

import com.aisino.service.DataAnalysisService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataAnalysisContext implements ApplicationContextAware {

    private Map<String, DataAnalysisService> machineStrategyMap = new ConcurrentHashMap<>();

    /**
     * 初始化machineStrategyMap
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, DataAnalysisService> dataAnalysisServiceMap = applicationContext.getBeansOfType(DataAnalysisService.class);
        dataAnalysisServiceMap.values().forEach(dataAnalysisService -> machineStrategyMap.put(dataAnalysisService.getDataType(),dataAnalysisService));
    }

    /**
     * 对数据进行分析 并发送数据
     *
     * @param datagram 数据
     * @param source 数据来源
     * @param invoiceLogId 日志主键
     */
    public void dataAnalysis(JSONObject datagram, String source, String invoiceLogId) {
        DataAnalysisService dataAnalysisService = machineStrategyMap.get(source);
        if (dataAnalysisService != null) {
            dataAnalysisService.dataAnalysis(datagram, invoiceLogId);
        }
    }
}
