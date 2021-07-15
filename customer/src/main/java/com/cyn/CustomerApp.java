package com.cyn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cyn.mapper")
@EnableDiscoveryClient
@EnableTransactionManagement
public class CustomerApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class);
    }
}
