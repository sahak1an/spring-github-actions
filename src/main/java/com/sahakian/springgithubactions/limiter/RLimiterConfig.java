package com.sahakian.springgithubactions.limiter;

import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.util.annotation.NonNull;

@Configuration
public class RLimiterConfig {

    @Bean
    public RateLimiterConfig limiterConfig(@NonNull LimiterProperty limiterProperty) {

        // 2 request per 10 second
        return RateLimiterConfig.custom()
                .limitForPeriod(limiterProperty.limitForPeriod())
                .limitRefreshPeriod(limiterProperty.limitRefreshPeriod())
                .timeoutDuration(limiterProperty.timeoutDuration())
                .build();
    }

    @Bean
    RateLimiterRegistry registry(RateLimiterConfig config) {
        return RateLimiterRegistry.of(config);
    }
}
