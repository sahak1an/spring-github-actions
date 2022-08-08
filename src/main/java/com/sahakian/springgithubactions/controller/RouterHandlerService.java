package com.sahakian.springgithubactions.controller;

import static io.github.resilience4j.ratelimiter.RateLimiter.decorateCheckedSupplier;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RouterHandlerService {

    private final RateLimiterRegistry limiterRegistry;

    public RouterHandlerService(@Qualifier("registry") RateLimiterRegistry limiterRegistry) {
        this.limiterRegistry = limiterRegistry;
    }

    public Mono<ServerResponse> handleIndexPage(ServerRequest serverRequest) {
        var name = serverRequest.headers().firstHeader("name");

        return Optional.ofNullable(name)
                .map(this::processName)
                .orElse(ServerResponse.badRequest().bodyValue("header not found!!"));
    }

    private Mono<ServerResponse> processName(String name) {
        var rateLimiter = limiterRegistry.rateLimiter(name);
        var headerName = decorateCheckedSupplier(rateLimiter, () -> name);

        try {
            var body = headerName.apply();

            return ServerResponse.ok().bodyValue(body);
        } catch (Throwable e) {
            return ServerResponse
                    .status(429)
                    .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                    .bodyValue("Many request");
        }
    }
}