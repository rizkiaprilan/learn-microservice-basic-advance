package com.example.cloudgatewayservice.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/employee/**")
                        //Pre and Post Filters provided by Spring Cloud Gateway
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-response", "first-response-header"))
                        .uri("http://localhost:8081/"))
                .route(r -> r.path("/consumer/**")
                        //Pre and Post Filters provided by Spring Cloud Gateway
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082/"))
                .build();
    }

//    @Bean
//    public GlobalFilter globalFilter() {
//        return (exchange, chain) -> {
//            System.out.println("First Global filter");
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                System.out.println("Second Global filter");
//            }));
//        };
//    }

}
