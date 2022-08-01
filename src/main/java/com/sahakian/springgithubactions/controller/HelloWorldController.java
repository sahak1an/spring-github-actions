package com.sahakian.springgithubactions.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping(value = "/hello", produces = APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<?>> sayHello() {
        return Mono.create(monoSink -> monoSink.success(ResponseEntity.ok(Map.of("message", "Hello"))));
    }
}
