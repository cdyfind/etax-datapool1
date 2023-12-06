package com.aisino.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * 服务平台税务进销项发票详情表(PlatformPurchaseSalesGoods)表实体类
 *
 * @author cdy
 * @since 2023-06-14 13:51:39
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformPurchaseSalesGoods extends Model<PlatformPurchaseSalesGoods> {
    //主键
    private String id;
    //日志id
    private String invoiceLogId;
    //服务平台发票id
    private String platformPurchaseSalesId;
    //税收分类编码
    private String ssflbm;
    //货物或应税劳务、服务名称
    private String hw;
    //规格型号
    private String ggxh;
    //单位
    private String dw;
    //数量
    private String quantity;
    //单价
    private String dj;
    //金额
    private String je;
    //税率
    private String sl;
    //税额
    private String se;
    //项目
    private String xm;



    }

