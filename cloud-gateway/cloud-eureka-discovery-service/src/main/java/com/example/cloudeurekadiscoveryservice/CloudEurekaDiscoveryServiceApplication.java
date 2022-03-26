package com.example.cloudeurekadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaDiscoveryServiceApplication.class, args);
    }

}
