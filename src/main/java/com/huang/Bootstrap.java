package com.huang;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource()
public class Bootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(Bootstrap.class).run(args);
    }
}