package com.kw.rcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
@SpringBootApplication(scanBasePackages = "com.kw.rcl")
@ImportResource("classpath:applicationContext.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("RCL start ok!");
    }
}
