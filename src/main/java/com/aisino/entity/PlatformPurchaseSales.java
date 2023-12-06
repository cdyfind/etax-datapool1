package com.aisino.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * 服务平台税务进销项发票表(PlatformPurchaseSales)表实体类
 *
 * @author cdy
 * @since 2023-06-14 13:51:30
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformPurchaseSales extends Model<PlatformPurchaseSales> {
    //主键
    private String id;
    //日志id
    private String invoiceLogId;
    //发票代码
    private String fpdm;
    //发票号码
    private String fphm;
    //开票日期
    private Date kprq;
    //发票状态(01:"正常",02:"已作废", 03:"已红冲-全额", 04:"已红冲-部分")
    private String fpzt;
    //销售方税号
    private String xfnsrsbh;
    //销售方名称
    private String xfmc;
    //购买方税号
    private String gfnsrsbh;
    //购买方名称
    private String gfmc;
    //金额
    private String je;
    //税额
    private String se;
    //价税合计
    private String jshj;
    //校验码
    private String jym;
    //销售方地址、电话
    private String xfdzdh;
    //销售方开户行及账号
    private String xfkhhzh;
    //购买方地址、电话
    private String gfdzdh;
    //购买方开户行及账号
    private String gfkhhzh;
    //密码区
    private String mmq;
    //备注
    private String bz;
    //机器编号
    private String jqbh;
    //开票人
    private String kpr;
    //收款人
    private String skr;
    //复核人
    private String fhr;
    //票价
    private String zfje;
    //买方单位代码/身份证号
    private String gfsh;
    //买方单位/个人住址
    private String gfdz;
    //买方电话
    private String gfdh;
    //卖方单位代码/身份证号
    private String xfsh;
    //卖方单位/个人住址
    private String xfdz;
    //卖方电话
    private String xfdh;
    //车牌照号
    private String cpzh;
    //登记证号
    private String djzh;
    //车辆类型
    private String cllx;
    //车架号/车辆识别代码
    private String clsbh;
    //厂牌型号
    private String cpxh;
    //转入地车辆管理所名称
    private String zrdglsmc;
    //车价合计
    private String cjhj;
    //经营、拍卖单位
    private String pmdwmc;
    //经营、拍卖单位地址
    private String pmdwdz;
    //经营、拍卖单位税号
    private String pmdwsh;
    //经营、拍卖单位开户银行、账号
    private String pmdwyhzh;
    //经营、拍卖单位电话
    private String pmdwdh;
    //二手车市场
    private String escsc;
    //二手车市场税号
    private String escscsh;
    //二手车市场地址
    private String escscdz;
    //二手车市场开户银行、账号
    private String escscyhzh;
    //二手车市场电话
    private String escsdh;
    //购买方单位
    private String gmfdw;
    //机打号码
    private String jdhm;
    //机器编码
    private String jqbm;
    //收款员
    private String sky;
    //税率
    private String sl;
    //姓名
    private String xm;
    //证件号码
    private String zjhm;
    //出发站
    private String cfz;
    //到达站
    private String ddz;
    //乘车车次
    private Long cccc;
    //日期
    private Date rq;
    //出发时间
    @TableField(value = "cfsj_1")
    private Date cfsj1;
    //席别
    @TableField(value = "xb_1")
    private String xb1;
    //车厢
    private String cx;
    //席位
    private String xw;
    //票种
    private String pz;
    //空调特征
    private String kttz;
    //电子客票号
    private String dzkph;
    //身份证号码/组织机构代码
    private String zzjgdm;
    //购买方纳税人识别号
    private String gfsbh;
    //产地
    private String cd;
    //合格证号
    private String hgzh;
    //进口证明书号
    private String jkzmsh;
    //商检单号
    private String sjdh;
    //发动机号码
    private String fdjhm;
    //车辆识别代号/车架号码
    private String cjhm;
    //购买方统一社会信用代码
    private String gmfnsrsbh;
    //销货单位名称
    private String xhdwmc;
    //电话
    private String dh;
    //销售方纳税人识别号
    private String nsrsbh;
    //账号
    private String zh;
    //地址
    private String dz;
    //开户银行
    private String khyhzh;
    //增值税税率或征收率
    private String slv;
    //增值税税额
    private String zzsse;
    //主管税务机关
    private String swjgMc;
    //主管税务机关代码
    private String swjgDm;
    //不含税价
    private String cjfy;
    //完税凭证号码
    private String wspzhm;
    //吨位
    private String dw;
    //限乘人数
    private String xcrs;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    //发票类型
    private String fplx;

    @TableField(exist = false)
    private JSONArray goods;

    }

