package com.diyishuai.hi1702.test;

import com.diyishuai.hi1702.domain.AutoConfig;
import com.diyishuai.hi1702.domain.dao.GodDao;
import com.diyishuai.hi1702.domain.dao.GodPartyDao;
import com.diyishuai.hi1702.domain.domain.God;
import com.diyishuai.hi1702.domain.domain.GodParty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Bruce
 * @since 2018/7/4
 */
@SpringBootTest(classes = {AutoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GPTest {

    @Autowired
    GodPartyDao godPartyDao;

    @Autowired
    GodDao godDao;

    @Test
    public void gpTest(){
        List<GodParty> allPartyMinRoll = godPartyDao.getAllPartyMinRoll();
        allPartyMinRoll.forEach(gp ->{
            System.out.println(gp);
        });

    }

    @Test
    public void godTest(){
        List<God> all = godDao.findAll();
        System.out.println(all);
    }

}
