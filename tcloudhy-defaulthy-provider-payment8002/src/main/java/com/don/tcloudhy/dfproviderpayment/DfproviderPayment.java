package com.don.tcloudhy.dfproviderpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class DfproviderPayment {
    public static void main(String[] args) {
        SpringApplication.run(DfproviderPayment.class, args);
    }
}
