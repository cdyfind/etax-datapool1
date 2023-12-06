package com.aisino.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * 发票校验数据货物信息表(BillInspectionDataGoods)表实体类
 *
 * @author cdy
 * @since 2023-06-14 13:51:20
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillInspectionDataGoods extends Model<BillInspectionDataGoods> {
    //主键
    private String id;
    //日志id
    private String invoiceLogId;
    //校验数据id
    private String inspectionDataId;
    //明细编号
    private String detailNo;
    //货物名称
    private String goodsName;
    //明细金额
    private String detailAmount;
    //数量
    private String num;
    //税率
    private String taxRate;
    //税额
    private String taxAmount;
    //含税单价
    private String taxUnitPrice;
    //含税金额
    private String taxDetailAmount;
    //不含税单价
    private String unitPrice;
    //规格型号
    private String specificationModel;
    //计量单位
    private String unit;
    //费用项目(货运发票返回信息)
    private String expenseItem;
    //（通行发票）车牌号
    private String plateno;
    //（通行发票）类型
    private String type;
    //(通行发票）通行日期起
    private String trafficDateStart;
    //（通行发票）通行日期止
    private String trafficDateEnd;
    //商品税收分类编码
    private String taxClassificationCode;
    //航段
    private String segment;
    //始发站 (明细)
    private String departureStation;
    //目的站(明细)
    private String destinationStation;
    //航班号
    private String flightNum;
    //座位等级
    private String seatClass;
    //承运日期
    private String carrierDate;
    //起飞时间
    private String departureTime;
    //客票级别/客票类型
    private String ticketLevelType;


    }

