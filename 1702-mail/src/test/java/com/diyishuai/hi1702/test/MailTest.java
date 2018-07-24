package com.diyishuai.hi1702.test;

import com.diyishuai.hi1702.mail.AutoConfig;
import com.diyishuai.hi1702.mail.bean.Mail;
import com.diyishuai.hi1702.mail.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruce
 * @since 2018/7/24
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AutoConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MailTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private Environment env;

    @Configuration
    @ComponentScan(basePackages = {"com.diyishuai.hi1702.mail"})
    public static class ContextConfiguration {

    }

    @Test
    public void emailSend(){
        Mail mail = new Mail();
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setTo("zhushuai026@gmail.com");
        mail.setSubject("1702-ROLL");
        mail.setTemplate("roll");
        Map model = new HashMap();

        mail.setModel(model);
        emailService.sendSimpleMessage(mail);
    }


}
