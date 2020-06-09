package com.lnsfwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = {"com.lnsfwx.mapper"})
@SpringBootApplication
@ComponentScan(basePackages = {"org.n3r.idworker","com.lnsfwx"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
