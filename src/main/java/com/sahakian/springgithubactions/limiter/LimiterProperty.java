package com.sahakian.springgithubactions.limiter;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "limiter")
public class LimiterProperty {
    private int limitForPeriod;
    private Duration limitRefreshPeriod;
    private Duration timeoutDuration;

    public int limitForPeriod() {
        return limitForPeriod;
    }

    public void setLimitForPeriod(int limitForPeriod) {
        this.limitForPeriod = limitForPeriod;
    }

    public Duration limitRefreshPeriod() {
        return limitRefreshPeriod;
    }

    public void setLimitRefreshPeriod(Duration limitRefreshPeriod) {
        this.limitRefreshPeriod = limitRefreshPeriod;
    }

    public Duration timeoutDuration() {
        return timeoutDuration;
    }

    public void setTimeoutDuration(Duration timeoutDuration) {
        this.timeoutDuration = timeoutDuration;
    }
}
