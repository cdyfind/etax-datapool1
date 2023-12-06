package com.aisino.entity;

import lombok.*;

@SuppressWarnings("serial")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JxptCyrzNew {
    //主键
    private String cyid;
    //纳税人识别号
    private String nsrsbh;
    //平台商编码
    private String username;
    //发票代码
    private String fpdm;
    //发票号码
    private String fphm;
    //开票日期
    private String kprq;
    //金额
    private String je;
    //校验码
    private String jym;
    //发票类型
    private String fplx;
    //查验接口id 01单票查验 02批量查验
    private String cyjkid;
    //批次号，批量查询时有值
    private String batchno;
    //创建时间
    private String cjsj;
    //查验接口执行时间
    private String cyzxtime;
    //查验状态 0失败 1成功
    private String cyzt;
    //查验返回状态
    private String cyfhzt;
    //企业编号
    private String qyid;
}
