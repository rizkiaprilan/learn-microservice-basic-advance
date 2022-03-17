package com.example.employeeconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "employee-producer")
public class EmployeeConsumerApplication {

    public static void main(String[] args) throws RestClientException {
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
