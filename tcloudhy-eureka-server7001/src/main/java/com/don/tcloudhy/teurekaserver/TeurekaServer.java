package com.don.tcloudhy.teurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class TeurekaServer {
    public static void main(String[] args)
    {
        SpringApplication.run(TeurekaServer.class, args);
    }
}
