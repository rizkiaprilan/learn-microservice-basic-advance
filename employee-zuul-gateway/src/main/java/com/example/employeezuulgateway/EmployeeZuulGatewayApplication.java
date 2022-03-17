package com.example.employeezuulgateway;

import com.example.employeezuulgateway.config.zuul.ErrorFilter;
import com.example.employeezuulgateway.config.zuul.PostFilter;
import com.example.employeezuulgateway.config.zuul.PreFilter;
import com.example.employeezuulgateway.config.zuul.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EmployeeZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeZuulGatewayApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
