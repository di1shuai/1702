package com.diyishuai.hi1702.api.scheduler;

import com.diyishuai.hi1702.domain.dao.GodPartyDao;
import com.diyishuai.hi1702.domain.dao.RollDetailDao;
import com.diyishuai.hi1702.domain.domain.GodParty;
import com.diyishuai.hi1702.domain.domain.RollDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class RollTask {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GodPartyDao godPartyDao;

    @Autowired
    private RollDetailDao rollDetailDao;

    @Scheduled(cron = "0 1 0 * * ?")
    public void rollNow(){
        Date date = new Date();
        List<RollDetail> rollDetailList = new ArrayList<>();
        List<GodParty> godPartyList = godPartyDao.findAll();

        godPartyList.forEach( godParty -> {
                Random random = new Random();
                Integer r = random.nextInt(101);
                godParty.setRollTaday(r);
                godParty.setUpdateTime(date);
                logger.info(">godPartId:{},roll:{}<",godParty.getId(),r);
                RollDetail rollDetail = new RollDetail();
                rollDetail.setGodPartyId(godParty.getId());
                rollDetail.setRollNum(r);
                rollDetail.setCreateTime(date);
                rollDetailList.add(rollDetail);
            }
        );
        godPartyDao.saveAll(godPartyList);
        rollDetailDao.saveAll(rollDetailList);
    }


}