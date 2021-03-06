package com.cyn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.cyn.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class ProductApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class);
    }
}
