package com.aisino.listener;

import cn.hutool.core.bean.BeanUtil;
import com.aisino.base.DataAnalysisContext;
import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.entity.InvoiceLog;
import com.aisino.pojo.ReqModel;
import com.aisino.service.*;
import com.aisino.util.CompressionUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;

/**
 * @author chengfan
 */
@Configuration
public class TestListener {

    @Resource
    private InvoiceLogService invoiceLogService;

    @Resource
    private DataAnalysisContext dataAnalysisContext;

    /**
     *
     * @param record 消费的数据
     * @param ack
     */
    @KafkaListener(topics = "${kafka.topic}",groupId = "${kafka.groupId}")
    public void test(ConsumerRecord<String,String> record, Acknowledgment ack){
        System.out.println("------接受数据-----");
        String payload = record.value();
        System.out.println("payload: "+payload);

        try{
            JSONObject jsonObject = JSONObject.parseObject(payload);
            String username = jsonObject.getString("userName");
            String nsrsbh = jsonObject.getString("nsrsbh");
            String source = jsonObject.getString("source");
            Boolean ysflag = jsonObject.getBoolean("ysFlag");

            String fplx = jsonObject.getString("fplx");

            InvoiceLog invoiceLog = new InvoiceLog();
            invoiceLog.setUsername(username);
            invoiceLog.setNsrsbh(nsrsbh);
            invoiceLog.setSource(source);
            invoiceLog.setYsFlag(ysflag);

            invoiceLog.setFplx(fplx);

            if (invoiceLog.getYsFlag()) {//判断状态
                //datagram对象使用工具类进行解压
                String datagram = jsonObject.getString("datagram");
                String s = CompressionUtil.decompressData(datagram);//拿到解压之后的字符串
                invoiceLog.setDatagram(JSONObject.parseObject(s, JSONObject.class));//字符串转JsonOBject对象加到log对象中
            } else {
                invoiceLog.setDatagram(jsonObject.getJSONObject("datagram"));
            }
            JSONObject datagram = new JSONObject();
            if ("jinsan".equals(source)) {
                // 金三数据
                JSONObject temp = invoiceLog.getDatagram();
                datagram.put("datagram", temp);
                datagram.put("fplx", fplx);
            } else {
                datagram = invoiceLog.getDatagram();
            }
            invoiceLog.setDatagram(datagram);
            InvoiceLog log= invoiceLogService.saveInvoiceLogService(invoiceLog);

//            dataAnalysisContext.dataAnalysis(log.getDatagram(), log.getSource(), log.getId());//传入对象
            System.out.println("------消费-----");
            System.out.println("invoiceLog: "+invoiceLog.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ack.acknowledge();
        }
    }


}
