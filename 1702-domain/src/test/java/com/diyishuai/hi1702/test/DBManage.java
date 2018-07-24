package com.diyishuai.hi1702.test;

import com.diyishuai.hi1702.domain.AutoConfig;
import com.diyishuai.hi1702.domain.dao.GodDao;
import com.diyishuai.hi1702.domain.dao.GodPartyDao;
import com.diyishuai.hi1702.domain.dao.PartyDao;
import com.diyishuai.hi1702.domain.dao.RollDetailDao;
import com.diyishuai.hi1702.domain.domain.God;
import com.diyishuai.hi1702.domain.domain.GodParty;
import com.diyishuai.hi1702.domain.domain.Party;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Bruce
 * @since 2018/7/3
 */
@EnableJpaAuditing
@SpringBootTest(classes = {AutoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DBManage {

    @Autowired
    GodDao godDao;

    @Autowired
    PartyDao partyDao;

    @Autowired
    GodPartyDao godPartyDao;

    @Autowired
    RollDetailDao rollDetailDao;

    @Test
    public void init(){
        God shuai = new God("帅神","zhushuai026@gmail.com");
        God ji = new God("吉神","2458047919@qq.com");
        God yu = new God("大神","13020020688@163.com");

        godDao.save(shuai);
        godDao.save(ji);
        godDao.save(yu);

        System.out.println(shuai.getId());

        Party party = new Party("1702");
        partyDao.save(party);

        System.out.println(party.getId());

        GodParty shuai1702 = new GodParty();
        shuai1702.setGodId(shuai.getId());
        shuai1702.setPartyId(party.getId());

        GodParty ji1702 = new GodParty();
        ji1702.setGodId(ji.getId());
        ji1702.setPartyId(party.getId());

        GodParty yu1702 = new GodParty();
        yu1702.setGodId(yu.getId());
        yu1702.setPartyId(party.getId());

        godPartyDao.save(shuai1702);
        godPartyDao.save(ji1702);
        godPartyDao.save(yu1702);

    }

    @Test
    public void clean(){
        godDao.deleteAll();
        godPartyDao.deleteAll();
        partyDao.deleteAll();
        rollDetailDao.deleteAll();
    }

}
