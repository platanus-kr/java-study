package config;

import aspect.ExecutiveTimeAspect;
import chap07.Calculator;
import chap07.RecurrenceCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppContext {

    @Bean
    public ExecutiveTimeAspect executiveTimeAspect() {
        return new ExecutiveTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecurrenceCalculator();
    }
}
