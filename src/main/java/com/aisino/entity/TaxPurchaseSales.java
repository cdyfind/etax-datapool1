package com.aisino.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * 税务进销项发票表(TaxPurchaseSales)表实体类
 *
 * @author cdy
 * @since 2023-06-14 13:51:47
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxPurchaseSales extends Model<TaxPurchaseSales> {
    //主键
    private String id;
    //日志id
    private String invoiceLogId;
    //序号
    private String xh;
    //发票代码
    private String fpdm;
    //发票号码
    private String fphm;
    //全电发票号码
    private String qdfphm;
    //销方识别号
    private String xfsbh;
    //销方名称
    private String xfmc;
    //购方识别号
    private String gfsbh;
    //购买方名称
    private String gfmc;
    //开票日期
    private Date kprq;
    //金额
    private String je;
    //税额
    private String se;
    //发票来源(1:增值税发票管理系统,2:电子发票服务平台)
    private Integer fply;
    //发票票种(01:"增值税专用发票",03:"机动车销售统一发票", 04:"增值税普通发票",08:"增值税电子专用发票",10:"增值税电子普通发票", 11:"增值税普通发票（卷式）", 14:"道路通行费电子普通发票",15:"二手车销售统一发票", 51:"数电票（铁路电子客票）",61:"数电票（航空运输电子客票行程单）", 81:"数电票（增值税专用发票）", 82:"数电票（普通发票）",85:"数电纸质发票（增值税专用发票）",86: "数电纸质发票（普通发票）")
    private String fppz;
    //发票状态(01:"正常",02:"已作废", 03:"已红冲-全额", 04:"已红冲-部分")
    private String fpzt;
    //发票风险等级(01:"正常",02:"异常凭证",03:"疑点发票")
    private String fxdj;
    //开票人
    private String kpr;
    //备注
    private String bz;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    @TableField(exist = false)
    private JSONArray detailes;

    }

