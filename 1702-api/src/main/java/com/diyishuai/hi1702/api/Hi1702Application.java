package com.diyishuai.hi1702.api;

import com.diyishuai.hi1702.domain.AutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@ComponentScan(basePackages = {"com.diyishuai.hi1702.domain","com.diyishuai.hi1702.api"})
@EntityScan(basePackages = {"com.diyishuai.hi1702.domain.domain"})
@EnableScheduling
@EnableJpaRepositories("com.diyishuai.hi1702.domain.dao")
@SpringBootApplication
public class Hi1702Application {

    public static void main(String[] args) {
        SpringApplication.run(Hi1702Application.class,args);
    }

}
