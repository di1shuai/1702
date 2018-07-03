package com.diyishuai.hi1702.test;

import com.diyishuai.hi1702.api.Hi1702Application;
import com.diyishuai.hi1702.api.service.RollService;
import com.diyishuai.hi1702.domain.AutoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
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
public class RollTest {

    @Autowired
    private RollService rollService;

    @Test
    public void rollTest(){
        rollService.rollNow();
    }

}
