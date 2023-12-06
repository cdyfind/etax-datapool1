package com.aisino.pojo;

import lombok.Data;
import com.alibaba.fastjson.JSONObject;
import lombok.ToString;

/**
 * @author chengfan
 */
@Data
@ToString
public class ReqModel {

    /**
     * 平台商编码
     */
    private String userName;

    /**
     * 纳税人识别号
     */
    private String nsrsbh;

    /**
     * 请求数据
     */
    private JSONObject datagram;

    /**
     * 发票类型
     */
    private String fplx;
}
