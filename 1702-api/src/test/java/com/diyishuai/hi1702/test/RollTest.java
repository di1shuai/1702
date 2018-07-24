package com.diyishuai.hi1702.test;

import com.diyishuai.hi1702.api.Hi1702Application;
import com.diyishuai.hi1702.api.scheduler.RollTask;
import com.diyishuai.hi1702.domain.AutoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Bruce
 * @since 2018/7/3
 */

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {AutoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Hi1702Application.class)
@EnableJpaAuditing
public class RollTest {

    @Autowired
    private RollTask rollTask;

    @Test
    public void rollTest(){
        rollTask.rollNow();
    }

    @Test
    public void sendMail(){
        rollTask.sendMail();
    }

}
