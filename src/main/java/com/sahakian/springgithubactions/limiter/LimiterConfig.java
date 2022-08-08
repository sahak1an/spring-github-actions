package com.sahakian.springgithubactions.limiter;

import java.time.Duration;

import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LimiterConfig {

    private static RateLimiterConfig limiterConfig() {

        // 2 request per 10 second
        return RateLimiterConfig.custom()
                .limitForPeriod(2)
                .limitRefreshPeriod(Duration.ofSeconds(10))
                .timeoutDuration(Duration.ofSeconds(1))
                .build();
    }

    @Bean
    RateLimiterRegistry registry() {
        return RateLimiterRegistry.of(limiterConfig());
    }
}
