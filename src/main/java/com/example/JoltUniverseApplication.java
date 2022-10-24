package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author oxy
 */
@MapperScan({"com.example.oxy.mapper"})
@SpringBootApplication
public class JoltUniverseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoltUniverseApplication.class, args);
    }

}
