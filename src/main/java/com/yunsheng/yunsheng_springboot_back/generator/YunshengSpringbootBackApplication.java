package com.yunsheng.yunsheng_springboot_back.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("generator.mapper")
public class YunshengSpringbootBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunshengSpringbootBackApplication.class, args);
        System.out.println("项目启动成功");
    }

}
