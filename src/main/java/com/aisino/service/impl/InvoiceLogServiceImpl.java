package com.aisino.service.impl;

import com.aisino.base.DataAnalysisContext;
import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.entity.PlatformPurchaseSalesGoods;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.InvoiceLogDao;
import com.aisino.entity.InvoiceLog;
import com.aisino.service.InvoiceLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 调用记录日志表(InvoiceLog)表服务实现类
 *
 * @author cdy
 * @since 2023-06-14 13:48:18
 */
@Service("invoiceLogService")
public class InvoiceLogServiceImpl extends ServiceImpl<InvoiceLogDao, InvoiceLog> implements InvoiceLogService {
    @Resource
    private IdGeneratorSnowflake snowflake;
    @Resource
    private DataAnalysisContext dataAnalysisContext;
    @Override
    public InvoiceLog saveInvoiceLogService(InvoiceLog entity) {
        Long snowflakeId = snowflake.snowflakeId();
        entity.setId(snowflakeId.toString());
//        this.save(entity);
        InvoiceLog invoiceLog = entity;
       /* String chayan = "{\n" +
                "    \"userName\": \"\",\n" +
                "    \"nsrsbh\": \"91110108MA001K7YXU\",\n" +
                "    \"source\": \"chayan\",\n" +
                "    \"datagram\": {\n" +
                "        \"draweeName\": \"\",\n" +
                "        \"businessUnit\": \"\",\n" +
                "        \"buyerUnitCodeOrIdNo\": \"\",\n" +
                "        \"lemonMarketTaxNo\": \"\",\n" +
                "        \"blueInvoiceCode\": \"\",\n" +
                "        \"transportGoodsInfo\": \"\",\n" +
                "        \"vehicleIdentificationNo\": \"\",\n" +
                "        \"invoiceAmount\": \"100.00\",\n" +
                "        \"zeroTaxRateFlag\": \"\",\n" +
                "        \"idNo\": \"\",\n" +
                "        \"throughAddress\": \"\",\n" +
                "        \"commodityInspectionNo\": \"\",\n" +
                "        \"payee\": \"\",\n" +
                "        \"businessUnitAddress\": \"\",\n" +
                "        \"licensePlate\": \"\",\n" +
                "        \"receiveName\": \"\",\n" +
                "        \"sellerUnitOrIndividual\": \"\",\n" +
                "        \"carrierName\": \"\",\n" +
                "        \"lemonMarket\": \"\",\n" +
                "        \"salerTaxNo\": \"91110000801145381H\",\n" +
                "        \"listTaxRate\": \"\",\n" +
                "        \"invoiceType\": \"10\",\n" +
                "        \"machineNo\": \"499098948152\",\n" +
                "        \"qualifiedNo\": \"\",\n" +
                "        \"invoiceNo\": \"95962562\",\n" +
                "        \"vehicleType\": \"\",\n" +
                "        \"engineNo\": \"\",\n" +
                "        \"limitedPeopleCount\": \"\",\n" +
                "        \"businessUnitPhone\": \"\",\n" +
                "        \"carPrice\": \"\",\n" +
                "        \"buyerTaxNo\": \"91110108MA001K7YXU\",\n" +
                "        \"salerBankAccount\": \"\",\n" +
                "        \"sellerPhone\": \"\",\n" +
                "        \"invoiceCode\": \"011002100311\",\n" +
                "        \"invoiceTypeNo\": \"\",\n" +
                "        \"checkCode\": \"01955318944392386526\",\n" +
                "        \"carNumber\": \"\",\n" +
                "        \"listTitle\": \"\",\n" +
                "        \"taxRate\": \"\",\n" +
                "        \"totalAmount\": \"100.00\",\n" +
                "        \"buyerPhone\": \"\",\n" +
                "        \"consignorTaxNo\": \"\",\n" +
                "        \"salerBankName\": \"\",\n" +
                "        \"salerAddressPhone\": \"北京市海淀区知春路63号中国卫星通信大厦B座15-19层010-88087755\",\n" +
                "        \"resultTip\": \"查验成功发票一致\",\n" +
                "        \"produceArea\": \"\",\n" +
                "        \"businessUnitTaxNo\": \"\",\n" +
                "        \"sellerUnitCodeOrIdNo\": \"\",\n" +
                "        \"detailList\": [\n" +
                "            {\n" +
                "                \"expenseItem\": \"\",\n" +
                "                \"unitPrice\": \"100.00\",\n" +
                "                \"specificationModel\": \"无\",\n" +
                "                \"plateNo\": \"\",\n" +
                "                \"num\": \"1\",\n" +
                "                \"trafficDateStart\": \"\",\n" +
                "                \"type\": \"\",\n" +
                "                \"taxDetailAmount\": \"\",\n" +
                "                \"taxRate\": \"不征税\",\n" +
                "                \"taxUnitPrice\": \"\",\n" +
                "                \"unit\": \"无\",\n" +
                "                \"detailNo\": \"1\",\n" +
                "                \"TaxClassificationCode\": \"6010000000000000000\",\n" +
                "                \"detailAmount\": \"100.00\",\n" +
                "                \"taxAmount\": \"***\",\n" +
                "                \"goodsName\": \"*预付卡销售*交通卡充值\",\n" +
                "                \"trafficDateEnd\": \"\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"listMark\": \"N\",\n" +
                "        \"carrierTaxNo\": \"\",\n" +
                "        \"taxAmount\": \"0.00\",\n" +
                "        \"taxAuthorityName\": \"\",\n" +
                "        \"salerName\": \"北京市政交通一卡通有限公司\",\n" +
                "        \"salerPhone\": \"\",\n" +
                "        \"taxDiskNumber\": \"\",\n" +
                "        \"resultCode\": \"0001\",\n" +
                "        \"blueInvoiceNo\": \"\",\n" +
                "        \"transferredVehicleOffice\": \"\",\n" +
                "        \"remark\": \"交易日期:2022年03月20日\",\n" +
                "        \"lemonMarketAddress\": \"\",\n" +
                "        \"pdfUrl\": \"\",\n" +
                "        \"taxPaymentCertificateNo\": \"\",\n" +
                "        \"buyerUnitOrIndividual\": \"\",\n" +
                "        \"tonnage\": \"\",\n" +
                "        \"lemonMarketPhone\": \"\",\n" +
                "        \"buyerAddressPhone\": \"\",\n" +
                "        \"taxAuthorityCode\": \"\",\n" +
                "        \"salerAccount\": \"中信银行北京北苑支行7116310182600002259\",\n" +
                "        \"vehicleTonnage\": \"\",\n" +
                "        \"cancellationMark\": \"N\",\n" +
                "        \"buyerUnitOrIndividualAddress\": \"\",\n" +
                "        \"draweeTaxNo\": \"\",\n" +
                "        \"checkCount\": \"2\",\n" +
                "        \"drawer\": \"\",\n" +
                "        \"lemonMarketBankAndAccount\": \"\",\n" +
                "        \"reviewer\": \"\",\n" +
                "        \"buyerName\": \"爱信诺征信有限公司\",\n" +
                "        \"invoiceDate\": \"20230131\",\n" +
                "        \"sellerUnitOrIndividualAddress\": \"\",\n" +
                "        \"businessUnitBankAndAccount\": \"\",\n" +
                "        \"consignorName\": \"\",\n" +
                "        \"salerAddress\": \"\",\n" +
                "        \"bandModel\": \"\",\n" +
                "        \"ofdUrl\": \"\",\n" +
                "        \"buyerAccount\": \"\",\n" +
                "        \"productOilFlag\": \"N\",\n" +
                "        \"registrationNo\": \"\",\n" +
                "        \"receiveTaxNo\": \"\",\n" +
                "        \"certificateOfImport\": \"\",\n" +
                "        \"invoiceTypeCode\": \"\",\n" +
                "        \"trafficFeeFlag\": \"N\"\n" +
                "    }\n" +
                "}";
        String jinsan = "{\n" +
                "    \"userName\": \"BAIDU511\",\n" +
                "    \"nsrsbh\": \"9114010072592573X2\",\n" +
                "    \"source\": \"jinsan\",\n" +
                "    \"fplx\": \"01\",\n" +
                "    \"datagram\": {\n" +
                "        \"total\": 2,\n" +
                "        \"invoices\": [  {\n" +
                "                \"fpdm\": \"6400221130\",\n" +
                "                \"gfmc\": \"中铁三局集团建筑安装工程有限公司\",\n" +
                "                \"xfkhhzh\": \"中国建设银行股份有限公司银川火车站支行64050122020000000829\",\n" +
                "                \"goods\": [\n" +
                "                    {\n" +
                "                        \"ssflbm\": \"1070214110000000000\",\n" +
                "                        \"ggxh\": \"50kg\",\n" +
                "                        \"se\": \"12837.5\",\n" +
                "                        \"dw\": \"千克\",\n" +
                "                        \"quantity\": \"3950\",\n" +
                "                        \"dj\": \"25\",\n" +
                "                        \"sl\": \"0.13\",\n" +
                "                        \"je\": \"98750\",\n" +
                "                        \"hw\": \"*化学试剂助剂*脱模剂\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"kpr\": \"任晓鹏\",\n" +
                "                \"mmq\": \"005-775/7>5>3738*-992*8<*63>90>-*-56/>72148224*-84-189-7-/13+/<3814+9<-3>+33+-+825442-/37/-*412+5001<+9103-467<4\",\n" +
                "                \"fhr\": \"马蓉\",\n" +
                "                \"se\": \"12837.5\",\n" +
                "                \"fpzt\": \"正常\",\n" +
                "                \"kprq\": \"2022-09-01\",\n" +
                "                \"gfdzdh\": \"山西省太原市小店区坞城东街南巷41号0351-2652611\",\n" +
                "                \"gfnsrsbh\": \"9114010072592573X2\",\n" +
                "                \"bz\": \"\",\n" +
                "                \"jshj\": \"111587.5\",\n" +
                "                \"xfdzdh\": \"宁夏回族自治区银川市金凤区长城路以南隆光金翠芳庭1号楼2单元902室17795019804\",\n" +
                "                \"je\": \"98750\",\n" +
                "                \"skr\": \"侯雯雪\",\n" +
                "                \"xfmc\": \"宁夏艾思特建材有限公司\",\n" +
                "                \"xfnsrsbh\": \"91640100MA76PLF04K\",\n" +
                "                \"gfkhhzh\": \"建行太原市河西支行14001835208050011842\",\n" +
                "                \"fphm\": \"02888002\",\n" +
                "                \"jym\": \"05520100906508494960\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"fpdm\": \"6400221130\",\n" +
                "                \"gfmc\": \"中铁三局集团建筑安装工程有限公司\",\n" +
                "                \"xfkhhzh\": \"中国建设银行股份有限公司银川火车站支行64050122020000000829\",\n" +
                "                \"goods\": [\n" +
                "                    {\n" +
                "                        \"ssflbm\": \"1070214110000000000\",\n" +
                "                        \"ggxh\": \"50kg\",\n" +
                "                        \"se\": \"3900\",\n" +
                "                        \"dw\": \"千克\",\n" +
                "                        \"quantity\": \"1200\",\n" +
                "                        \"dj\": \"25\",\n" +
                "                        \"sl\": \"0.13\",\n" +
                "                        \"je\": \"30000\",\n" +
                "                        \"hw\": \"*化学试剂助剂*脱模剂\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"kpr\": \"任晓鹏\",\n" +
                "                \"mmq\": \"00598520366>3352*81>384*31773*-<-23-58600>0649+<0>71956/8-61924*402-227-7872/>>>8/402543+6*91*6*3601<+9103->56-4\",\n" +
                "                \"fhr\": \"马蓉\",\n" +
                "                \"se\": \"3900\",\n" +
                "                \"fpzt\": \"正常\",\n" +
                "                \"kprq\": \"2022-09-01\",\n" +
                "                \"gfdzdh\": \"山西省太原市小店区坞城东街南巷41号0351-2652611\",\n" +
                "                \"gfnsrsbh\": \"9114010072592573X2\",\n" +
                "                \"bz\": \"\",\n" +
                "                \"jshj\": \"33900\",\n" +
                "                \"xfdzdh\": \"宁夏回族自治区银川市金凤区长城路以南隆光金翠芳庭1号楼2单元902室17795019804\",\n" +
                "                \"je\": \"30000\",\n" +
                "                \"skr\": \"侯雯雪\",\n" +
                "                \"xfmc\": \"宁夏艾思特建材有限公司\",\n" +
                "                \"xfnsrsbh\": \"91640100MA76PLF04K\",\n" +
                "                \"gfkhhzh\": \"建行太原市河西支行14001835208050011842\",\n" +
                "                \"fphm\": \"02888003\",\n" +
                "                \"jym\": \"07383470490254769293\"\n" +
                "            }]\n" +
                "    }\n" +
                "}";
        String jinsi = "{\n" +
                "    \"nsrsbh\": \"91441200MA51BYKN5A\",\n" +
                "    \"datagram\": {\n" +
                "        \"total\": 1,\n" +
                "        \"invoices\": [\n" +
                "            {\n" +
                "                \"fply\": \"1\",\n" +
                "                \"fppz\": \"10\",\n" +
                "                \"fpzt\": \"01\",\n" +
                "                \"fxdj\": \"01\",\n" +
                "                \"kpr\": \"利宝保险\",\n" +
                "                \"bz\": \"车牌号:粤H76Y85车牌号:粤H76Y85、税款所属期 2022-01-01至2022-12-31、代收车船税 300.00、滞纳金0.0保单号8827244497220000401000、车牌号:粤H76Y85总计:1798.74元\",\n" +
                "                \"xh\": \"72\",\n" +
                "                \"fpdm\": \"044002033311\",\n" +
                "                \"fphm\": \"52933729\",\n" +
                "                \"qdfphm\": \"--\",\n" +
                "                \"xfsbh\": \"91441200MA51BYKN5A\",\n" +
                "                \"xfmc\": \"利宝保险有限公司肇庆中心支公司四会营销服务部\",\n" +
                "                \"gfsbh\": \"000000000000000\",\n" +
                "                \"gfmc\": \"范慧婷\",\n" +
                "                \"kprq\": \"2022-03-09 11:48:54\",\n" +
                "                \"je\": \"1413.9\",\n" +
                "                \"se\": \"84.84\",\n" +
                "                \"detailes\": [\n" +
                "                    {\n" +
                "                        \"mcsl\": \"6%\",\n" +
                "                        \"mxse\": \"30.78\",\n" +
                "                        \"mxfpdm\": \"044002033311\",\n" +
                "                        \"mxfphm\": \"52933729\",\n" +
                "                        \"mxqdfphm\": \"\",\n" +
                "                        \"mxssflbm\": \"3060302990000000000\",\n" +
                "                        \"mxhwmc\": \"*保险服务*机动车辆保险(示范)\",\n" +
                "                        \"ggxh\": \"8805024497220000483000\",\n" +
                "                        \"mxdw\": \"份\",\n" +
                "                        \"mxspsl\": \"1.00000000\",\n" +
                "                        \"mxdj\": \"512.96000000\",\n" +
                "                        \"mxje\": \"512.96\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"mcsl\": \"6%\",\n" +
                "                        \"mxse\": \"48.4\",\n" +
                "                        \"mxfpdm\": \"044002033311\",\n" +
                "                        \"mxfphm\": \"52933729\",\n" +
                "                        \"mxqdfphm\": \"\",\n" +
                "                        \"mxssflbm\": \"3060302020000000000\",\n" +
                "                        \"mxhwmc\": \"*保险服务*机动车交强险\",\n" +
                "                        \"ggxh\": \"8805084497220000952000\",\n" +
                "                        \"mxdw\": \"份\",\n" +
                "                        \"mxspsl\": \"1.00000000\",\n" +
                "                        \"mxdj\": \"806.60000000\",\n" +
                "                        \"mxje\": \"806.6\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"mcsl\": \"6%\",\n" +
                "                        \"mxse\": \"5.66\",\n" +
                "                        \"mxfpdm\": \"044002033311\",\n" +
                "                        \"mxfphm\": \"52933729\",\n" +
                "                        \"mxqdfphm\": \"\",\n" +
                "                        \"mxssflbm\": \"3060301990000000000\",\n" +
                "                        \"mxhwmc\": \"*保险服务*驾乘人员意外伤害保险\",\n" +
                "                        \"ggxh\": \"8827244497220000401000\",\n" +
                "                        \"mxdw\": \"份\",\n" +
                "                        \"mxspsl\": \"1.00000000\",\n" +
                "                        \"mxdj\": \"94.34000000\",\n" +
                "                        \"mxje\": \"94.34\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "                \n" +
                "            {\n" +
                "                \"fply\": \"1\",\n" +
                "                \"fppz\": \"10\",\n" +
                "                \"fpzt\": \"01\",\n" +
                "                \"fxdj\": \"01\",\n" +
                "                \"kpr\": \"利宝保险\",\n" +
                "                \"bz\": \"车牌号:粤HCB200、税款所属期 2022-01-01至2022-12-31、代收车船税 300.00、滞纳金0.0总计:1180.00元\",\n" +
                "                \"xh\": \"73\",\n" +
                "                \"fpdm\": \"044002033311\",\n" +
                "                \"fphm\": \"52933728\",\n" +
                "                \"qdfphm\": \"--\",\n" +
                "                \"xfsbh\": \"91441200MA51BYKN5A\",\n" +
                "                \"xfmc\": \"利宝保险有限公司肇庆中心支公司四会营销服务部\",\n" +
                "                \"gfsbh\": \"000000000000000\",\n" +
                "                \"gfmc\": \"苏桥科\",\n" +
                "                \"kprq\": \"2022-03-09 08:41:27\",\n" +
                "                \"je\": \"830.19\",\n" +
                "                \"se\": \"49.81\",\n" +
                "                \"detailes\": [\n" +
                "                    {\n" +
                "                        \"mcsl\": \"6%\",\n" +
                "                        \"mxse\": \"49.81\",\n" +
                "                        \"mxfpdm\": \"044002033311\",\n" +
                "                        \"mxfphm\": \"52933728\",\n" +
                "                        \"mxqdfphm\": \"\",\n" +
                "                        \"mxssflbm\": \"3060302020000000000\",\n" +
                "                        \"mxhwmc\": \"*保险服务*机动车交强险\",\n" +
                "                        \"ggxh\": \"8805084497220000951000\",\n" +
                "                        \"mxdw\": \"份\",\n" +
                "                        \"mxspsl\": \"1.00000000\",\n" +
                "                        \"mxdj\": \"830.19000000\",\n" +
                "                        \"mxje\": \"830.19\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"source\": \"jinsi\",\n" +
                "    \"userName\": \"BAIDU511\"\n" +
                "}";*/
        if (entity.getSource().equals("chayan")){
            invoiceLog.setId(snowflakeId.toString());
            this.save(invoiceLog);
            dataAnalysisContext.dataAnalysis(invoiceLog.getDatagram(),entity.getSource(),snowflakeId.toString());
        } else if (entity.getSource().equals("jinsan")){
            invoiceLog.setId(snowflakeId.toString());
            this.save(invoiceLog);
            dataAnalysisContext.dataAnalysis(invoiceLog.getDatagram(),entity.getSource(),snowflakeId.toString());
        } else if (entity.getSource().equals("jinsi")){
            invoiceLog.setId(snowflakeId.toString());
            this.save(invoiceLog);
            dataAnalysisContext.dataAnalysis(invoiceLog.getDatagram(),entity.getSource(),snowflakeId.toString());
        }
        return entity;
    }
}

