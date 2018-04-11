package com.gatewaytest.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class RouteConfig {
    private final static Logger logger = LoggerFactory.getLogger(RouteConfig.class);
    @Autowired
    ApplicationContext context;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        Binder binder = Binder.get(context.getEnvironment());

        return builder.routes()
                .route("path_route", r -> r.path("/aaa/**")
                        .filters(f -> f
//                                        .filter(new SessionFilter().setServiceid("aaa").
//                                                setSessionurl(gProperties.getGetsessionurl()).
//                                                setRestTemplate(restTemplate))
                                        .hystrix(config -> config.setName("aaacmd").setFallbackUri(URI.create("forward:/aaafallback")))
//                                .retry(config->config.setRetries(1).setSeries(HttpStatus.Series.SERVER_ERROR))
                        )
                        .uri("lb:http://aaa"))
                .build();
    }

}
