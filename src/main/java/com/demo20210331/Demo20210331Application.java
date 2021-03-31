package com.demo20210331;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo20210331.mapper")
public class Demo20210331Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo20210331Application.class, args);
    }

}
