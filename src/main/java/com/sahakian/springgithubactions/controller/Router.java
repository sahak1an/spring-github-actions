package com.sahakian.springgithubactions.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class Router {

    @Bean
    RouterFunction<ServerResponse> getEmployeeByIdRoute(RouterHandlerService handlerService) {
        return route(GET("/"), handlerService::handleIndexPage);
    }
}
