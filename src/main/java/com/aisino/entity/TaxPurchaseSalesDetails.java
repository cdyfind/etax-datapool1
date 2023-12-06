package com.aisino.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * 税务进销项发票详情表(TaxPurchaseSalesDetails)表实体类
 *
 * @author cdy
 * @since 2023-06-14 13:51:59
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxPurchaseSalesDetails extends Model<TaxPurchaseSalesDetails> {
    //主键
    private String id;
    //日志id
    private String invoiceLogId;
    //税务进销项发票id
    private String taxPurchaseSaleId;
    //发票代码
    private String mxfpdm;
    //发票号码
    private String mxfphm;
    //数电票号码
    private String mxqdfphm;
    //税收分类编码
    private String mxssflbm;
    //销方货物或应税劳务名称
    private String mxhwmc;
    //规格型号
    private String ggxh;
    //单位
    private String mxdw;
    //数量
    private String mxspsl;
    //单价
    private String mxdj;
    //金额
    private String mxje;
    //税率
    private String mcsl;
    //税额
    private String mxse;


    }

