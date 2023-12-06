package com.aisino.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillInspectionDataVO {
    //主键
    private String id;
    //发票种类
    private String invoiceType;
    //发票代码
    private String invoiceCode;
    //发票号码
    private String invoiceNo;
    //查验次数
    private String checkCount;
    //销方税号
    private String salerTaxNo;
    //销方名称
    private String salerName;
    //纳税人识别号
    private String nsrsbh;
    //平台商编码
    private String username;
    //数据来源
    private String source;
    //发票类型
    private String fplx;



    }
