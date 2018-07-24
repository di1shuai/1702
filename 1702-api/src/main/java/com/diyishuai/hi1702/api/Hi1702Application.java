package com.diyishuai.hi1702.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@ComponentScan(basePackages = {"com.diyishuai.hi1702.domain","com.diyishuai.hi1702.api","com.diyishuai.hi1702.mail"})
@EntityScan(basePackages = {"com.diyishuai.hi1702.domain.domain"})
@EnableScheduling
@EnableJpaRepositories("com.diyishuai.hi1702.domain.dao")
@EnableJpaAuditing
@SpringBootApplication
public class Hi1702Application {

    public static void main(String[] args) {

        SpringApplication.run(Hi1702Application.class,args);
    }

}
