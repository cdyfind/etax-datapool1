package com.aisino.test;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;

import java.util.Properties;
import java.util.Set;

/**
 * @author chengfan
 */
public class TestKafka {

    public static boolean kafkaAlive(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "172.31.115.7:10129");
//        properties.put("bootstrap.servers", "172.19.1.209:9092");
        properties.put("connections.max.idle.ms", 10000);
        properties.put("request.timeout.ms", 5000);
        try (AdminClient client = KafkaAdminClient.create(properties)) {
            ListTopicsResult topics = client.listTopics(new ListTopicsOptions().timeoutMs(5000));
            Set<String> names = topics.names().get();
            System.out.println("connect to kafka cluster success");
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(kafkaAlive());
    }

}
