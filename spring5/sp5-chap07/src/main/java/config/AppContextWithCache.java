package config;

import aspect.CacheAspect;
import aspect.ExecutiveTimeAspect;
import chap07.Calculator;
import chap07.RecurrenceCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppContextWithCache {

    @Bean
    public CacheAspect cacheAspect() {
        return new CacheAspect();
    }

    @Bean
    public ExecutiveTimeAspect executiveTimeAspect() {
        return new ExecutiveTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecurrenceCalculator();
    }
}
