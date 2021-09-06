package com.example.multidb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.multidb.dao")
@SpringBootApplication
public class MultiDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDbApplication.class, args);
    }

}
