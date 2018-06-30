package com.diyishuai.hi1702.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@ComponentScan(basePackages = {"com.diyishuai"})
@EntityScan(basePackages = {"com.diyishuai.hi1702.domain.domain"})
@SpringBootApplication
public class Hi1702Application {

    public static void main(String[] args) {
        SpringApplication.run(Hi1702Application.class,args);
    }

}
