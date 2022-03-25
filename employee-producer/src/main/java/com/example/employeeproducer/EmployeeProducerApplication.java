package com.example.employeeproducer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableCircuitBreaker
@EnableDiscoveryClient
@RefreshScope
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
@SpringBootApplication
public class EmployeeProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProducerApplication.class, args);
    }

}
@Controller
@ResponseBody
class PropertyHttpController {

    @Autowired
    Environment environment;

    @GetMapping("/value")
    String read() {
        return this.readValue();
    }

    @EventListener({
            RefreshRemoteApplicationEvent.class,
            ApplicationReadyEvent.class,
            RefreshScopeRefreshedEvent.class})
    public void refresh() {
        System.out.println("the new value is " + this.readValue());
    }

    private String readValue() {
        return this.environment.getProperty("eureka.client.serviceUrl.defaultZone");
    }
}
