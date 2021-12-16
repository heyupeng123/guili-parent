package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient  // nacos注册
@EnableFeignClients
@ComponentScan(basePackages = {"com.atguigu.servicebase","com.atguigu.eduservice"})
public class EduApplicationMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(EduApplicationMain8001.class,args);
    }
}
