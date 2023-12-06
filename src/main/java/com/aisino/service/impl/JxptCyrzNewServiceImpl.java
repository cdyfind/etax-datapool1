package com.aisino.service.impl;


import cn.hutool.http.HttpUtil;
import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.dao.JxptCyrzNewDao;
import com.aisino.entity.JxptCyrzNew;
import com.aisino.service.JxptCyrzNewService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


@Service("JxptCyrzNewService")
public class JxptCyrzNewServiceImpl extends ServiceImpl<JxptCyrzNewDao, JxptCyrzNew> implements JxptCyrzNewService {
    @Resource
    private IdGeneratorSnowflake snowflake;
    @Override
    public JxptCyrzNew saveJxptCyrzNew(JxptCyrzNew entity) {
        Long snowflakeId = snowflake.snowflakeId();
        entity.setCyid(snowflakeId.toString());
        this.save(entity);
        return entity;
    }


    @Override
    public void check() {
        Lock lock = new ReentrantLock();
        lock.lock();
        /**
         * 一 根据发票代码,发票号码分组查询数据列表并过滤状态为空的前一百条数据
         * 二 根据查到的数据进行调用接口获取到返回结果
         * 三 拿到返回结果放入kafka队列
         * 四 修改当前数据状态不为空
         */
        try {
            // 创建Kafka Producer的配置信息
            Properties props = new Properties();
            props.put("bootstrap.servers", "http://172.31.115.7:10129"); // Kafka服务器地址
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // 键的序列化器
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // 值的序列化器
            //0、1 和 all：0表示只要把消息发送出去就返回成功；1表示只要Leader收到消息就返回成功；all表示所有副本都写入数据成功才算成功
            props.put("acks", "all");
            //重试次数
            props.put("retries", 6);
            //批处理的字节数
            props.put("batch.size", 16384);
            //批处理的延迟时间，当批次数据未满之时等待的时间
            props.put("linger.ms", 1);
            //用来约束KafkaProducer能够使用的内存缓冲的大小的，默认值32MB
            props.put("buffer.memory", 33554432);
            // 创建Kafka Producer
            KafkaProducer<String, String> producer = new KafkaProducer<>(props);

            //根据发票代码,发票号码分组查询数据列表并过滤状态为空的前一百条数据
            Page<JxptCyrzNew> page = new Page<>(1, 100);
            MPJLambdaWrapper<JxptCyrzNew> mpjLambdaWrapper=new MPJLambdaWrapper<>();
            mpjLambdaWrapper.selectAll(JxptCyrzNew.class)
                    .groupBy(JxptCyrzNew::getFpdm,JxptCyrzNew::getFphm)
                    .isNull(JxptCyrzNew::getCyfhzt)
                    .orderByAsc(JxptCyrzNew::getCjsj);
            //查询到需要的分页数据
            Page<JxptCyrzNew> pages = this.page(page, mpjLambdaWrapper);
            //拿到集合
            List<JxptCyrzNew> list = pages.getRecords();
            list.stream().forEach(o->{
             //这里需要处理调用接口的参数 将本次循环对象的参数放入map中转为json字符串传入接口调用
                // 先创建datagram的内容
                JSONObject datagram = new JSONObject();
                datagram.put("fpdm", o.getFpdm());
                datagram.put("fphm", o.getFphm());
                datagram.put("kprq", o.getKprq());
                datagram.put("je", o.getJe());
                datagram.put("jym", o.getJym());
                Map<String, Object> params = new HashMap<>();
                params.put("interfaceCode", "51ys.jx.verify.web.query");
                params.put("zipCode","");
                params.put("encryptCode","");
                params.put("access_token", "");
                params.put("datagram", datagram);
                params.put("signtype", "");
                params.put("signature", "");
                String jsonString = JSON.toJSONString(params);
                /* 迭代集合调用接口
                参数{
                  urlString : 调用地址
                 body 参数的json字符串
                return 调用结果json
                 } */
                String jsonstr = HttpUtil.post("http://taxapi.51fapiao.cn/api/v1.0/51ys.jx.verify.web.query",jsonString);
                // 将调用结果放入Kafka队列
                producer.send(new ProducerRecord<>("etax-datapool-demo", jsonstr), (metadata, exception) -> {
                    if (exception == null) {
                        System.out.println("发送成功，偏移量：" + metadata.offset());
                    } else {
                        System.out.println("发送失败，错误信息：" + exception.getMessage());
                    }
                });
                //修改查验返回状态不为空
            })  ;
            producer.close();
        } finally {
            lock.unlock();
        }
    }

}

