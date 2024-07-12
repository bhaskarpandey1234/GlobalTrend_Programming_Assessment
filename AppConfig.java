package logexecutiontime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import logexecutiontime.aspect.LogExecutionTimeAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public LogExecutionTimeAspect logExecutionTimeAspect() {
        return new LogExecutionTimeAspect();
    }
}
