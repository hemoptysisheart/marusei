package com.github.smdj.marusei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Launcher {
    private static final Logger log = LoggerFactory.getLogger(Launcher.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Launcher.class, args);
        if (log.isTraceEnabled()) {
            for (String name:context.getBeanDefinitionNames()) {
                log.trace("{} = {}", name, context.getBean(name));
            }
        }
    }
}
