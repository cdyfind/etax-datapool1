package com.aisino.service;

import com.alibaba.fastjson.JSONObject;

public interface DataAnalysisService {

    //数据类型
    public String getDataType();

    // 解析模块数据
    public void dataAnalysis(JSONObject datagram, String invoiceLogId);
}
