package com.aisino.test;

import com.aisino.entity.Records;
import com.aisino.entity.TestData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

    private void listTest(){
        String test = "{\n" +
                "    \"message\": \"成功\",\n" +
                "    \"code\": 1,\n" +
                "    \"records\": [\n" +
                "        {\n" +
                "            \"id\": 99309,\n" +
                "            \"brokerName\": \"\",\n" +
                "            \"fileType\": \"协议\",\n" +
                "            \"effectiveDate\": \"20220818\",\n" +
                "            \"createDate\": \"20220812\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 99308,\n" +
                "            \"brokerName\": \"\",\n" +
                "            \"fileType\": \"合同\",\n" +
                "            \"effectiveDate\": \"20220812\",\n" +
                "            \"createDate\": \"20220812\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject object = JSON.parseObject(test);
//        TestData testData = JSONObject.toJavaObject(object, TestData.class);
        TestData testData = JSON.parseObject(object.toJSONString(),TestData.class);
        JSONArray jsonArray = object.getJSONArray("records");
        List<Records> records = JSON.parseArray(jsonArray.toJSONString(), Records.class);
        List<Records> collect = records.stream().map(m -> {
//            InvoiceLog invoiceLog = new InvoiceLog();
//            BeanUtil.copyProperties(m, invoiceLog);
            m.setId("312312");
            return m;
        }).collect(Collectors.toList());
        System.out.printf(collect.toString());

    }
    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.listTest();
    }
}
