package com.aisino;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengfan
 */
@SpringBootApplication
@MapperScan(value = { "com.aisino.dao" })
public class DataPoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataPoolApplication.class, args);
    }

}
