package com.demo.client;

import com.demo.sdk.annotation.EnableFilters;
import com.demo.sdk.util.ContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动类
 */
@EnableFeignClients
@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
@EnableFilters
@ComponentScan(basePackages = {"com.demo"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println(ContextUtils.getApplicationName());
    }

}
