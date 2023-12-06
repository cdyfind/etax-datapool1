package com.aisino.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * 发票校验数据(BillInspectionData)表实体类
 *
 * @author cdy
 * @since 2023-06-14 13:50:41
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillInspectionData extends Model<BillInspectionData> {
    //主键
    private String id;
    //日志id
    private String invoiceLogId;
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
    //销方地址、电话
    private String salerAddressPhone;
    //销方开户行及账号
    private String salerAccount;
    //购方税号
    private String buyerTaxNo;
    //购方名称
    private String buyerName;
    //购方地址、电话
    private String buyerAddressPhone;
    //购方开户行及账号
    private String buyerAccount;
    //开票日期
    private Date invoiceDate;
    //发票金额
    private String invoiceAmount;
    //发票税额
    private String taxAmount;
    //价税合计
    private String totalAmount;
    //备注
    private String remark;
    //机器编号
    private String machineNo;
    //开票人
    private String drawer;
    //收款人
    private String payee;
    //复核人
    private String reviewer;
    //校验码
    private String checkCode;
    //蓝票发票代码
    private String blueInvoiceCode;
    //蓝票发票号码
    private String blueInvoiceNo;
    //作废标志
    private String cancellationMark;
    //购方身份证号/组织机构代码（机动车）
    private String idNo;
    //车辆类型（机动车）
    private String vehicleType;
    //厂牌型号（机动车）
    private String bandModel;
    //产地（机动车）
    private String produceArea;
    //合格证号（机动车）
    private String qualifiedNo;
    //商检单号（机动车）
    private String commodityInspectionNo;
    //发动机号（机动车）
    private String engineNo;
    //车辆识别代号/车架号码（机动车）
    private String vehicleidentificationNo;
    //进口证明书号（机动车）
    private String certificateOfimport;
    //主管税务机关代码（机动车）
    private String taxAuthorityCode;
    //完税凭证号码（机动车）
    private String taxPaymentCertificateNo;
    //限乘人数（机动车）
    private String limitedPeopleCount;
    //主管税务机关名称（机动车）
    private String taxAuthorityName;
    //吨位（机动车）
    private String tonnage;
    //税率（机动车）
    private String taxRate;
    //销方地址（机动车）
    private String salerAddress;
    //销方电话（机动车）
    private String salerPhone;
    //销方开户银行（机动车）
    private String salerBankName;
    //销方开户账号（机动车）
    private String salerBankAccount;
    //（货运票）承运人名称
    private String carrierName;
    //（货运票）承运人识别号
    private String carrierTaxNo;
    //（货运票）受票方名称
    private String draweeName;
    //（货运）受票方识别号
    private String draweeTaxNo;
    //（货运票）收货人名称
    private String receiveName;
    //（货运票）收货人识别号
    private String receiveTaxNo;
    //（货运票）发货人名称
    private String consignorName;
    //（货运票）发货人识别号
    private String consignorTaxNo;
    //（货运票）运输货物信息
    private String transportGoodsInfo;
    //（货运票）起止地、经由、到达地
    private String throughAddress;
    //（货运票）税控盘号
    private String taxDiskNumber;
    //（货运）车种车号
    private String carNumber;
    //（货运票）车船吨位
    private String vehicleTonnage;
    //（通行发票）通行费标志Y-可抵扣，N-不可抵扣
    private String trafficFeeFlag;
    // 成品油标志 Y代表是 N代表不是
    private String productOilFlag;
    //（通行发票）零税率标志1： 税率栏位显示“免税”
    private String zeroTaxRateFlag;
    //车牌照号
    private String licensePlate;
    //登记证号
    private String registrationNo;
    //车价合计
    private String carPrice;
    //转入地车辆车管所名
    private String transferredVehicleOffice;
    //买方单位/个人
    private String buyerUnitOrIndividual;
    //买方单位代码/身份证号
    private String buyerUnitCodeOrIdNo;
    //买方单位
    private String buyerUnitOrIndividualAddress;
    //买方电话
    private String buyerPhone;
    //卖方单位/个人
    private String sellerUnitOrIndividual;
    //卖方单位
    private String sellerUnitOrIndividualAddress;
    //卖方单位代码
    private String sellerUnitCodeOrIdNo;
    //卖方电话
    private String sellerPhone;
    //经营、拍卖单位
    private String businessUnit;
    //经营、拍卖单位地址
    private String businessUnitAddress;
    //经营、拍卖单位纳税
    private String businessUnitTaxNo;
    //开户银行及账号
    private String businessUnitBankAndAccount;
    //经营、拍卖单位电话
    private String businessUnitPhone;
    //二手车市场
    private String lemonMarket;
    //二手车市场纳税人识别号
    private String lemonMarketTaxNo;
    //二手车市场地址
    private String lemonMarketAddress;
    //二手车市场开户银行及账号
    private String lemonMarketBankAndAccount;
    //清单标题
    private String listTitle;
    //清单标志
    private String listMark;
    //清单税率
    private String listTaxRate;
    //二手车市场电话
    private String lemonMarketPhone;
    //Ofd文件下载链接
    private String ofdUrl;
    //pdf文件下载链接
    private String pdfUrl;
    //业务类型
    private String businessType;
    //姓名
    private String name;
    //票价
    private String fare;
    //出发站
    private String departureStation;
    //到达站
    private String arrivalStation;
    //车次
    private String trainNo;
    //乘车日期
    private String boardingDate;
    //出发时间
    private String departureTime;
    //席别
    private String xb;
    //车厢
    private String carriage;
    //席位
    private String xw;
    //电子客票号
    private String ticketNo;
    //空调特征
    private String airConditionCharacter;
    //购买方统一社会信用代码
    private String buyerSocialCreditId;
    //新电票标识
    private String eleInvoiceFlag;
    //国内国际标识
    private String internationalId;
    //GP 单号
    private String GPNumber;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;


    }

