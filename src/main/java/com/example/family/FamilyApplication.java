package com.example.family;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*@ComponentScan(basePackages = {"com.example.family.config"})*/
@MapperScan("com.example.family.*.mapper")
@SpringBootApplication
public class FamilyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyApplication.class, args);
        System.out.println("启动成功");
    }

}
