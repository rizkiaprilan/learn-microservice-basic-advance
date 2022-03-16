package com.example.employeeconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeConsumerApplication {

    public static void main(String[] args) throws RestClientException, IOException {
        ApplicationContext ctx = SpringApplication.run(EmployeeConsumerApplication.class, args);

        ConsumerControllerClient ctxBean = ctx.getBean(ConsumerControllerClient.class);

        System.out.println(ctxBean);
        ctxBean.getEmployee();

    }

    @Bean
    public ConsumerControllerClient consumerControllerClient() {
        return new ConsumerControllerClient();
    }

}
