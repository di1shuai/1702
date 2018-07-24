package com.diyishuai.hi1702.api.scheduler;

import com.diyishuai.hi1702.domain.dao.GodDao;
import com.diyishuai.hi1702.domain.dao.GodPartyDao;
import com.diyishuai.hi1702.domain.dao.RollDetailDao;
import com.diyishuai.hi1702.domain.domain.God;
import com.diyishuai.hi1702.domain.domain.GodParty;
import com.diyishuai.hi1702.domain.domain.RollDetail;
import com.diyishuai.hi1702.mail.bean.Mail;
import com.diyishuai.hi1702.mail.service.EmailService;
import org.assertj.core.util.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RollTask {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

    @Autowired
    private GodDao godDao;

    @Autowired
    private GodPartyDao godPartyDao;

    @Autowired
    private RollDetailDao rollDetailDao;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 1 0 * * ?")
    public void rollNow(){
        List<RollDetail> rollDetailList = new ArrayList<>();
        List<GodParty> godPartyList = godPartyDao.findAll();

        godPartyList.forEach( godParty -> {
                Random random = new Random();
                Integer r = random.nextInt(101);
                godParty.setRollTaday(r);
                logger.info(">godPartId:{},roll:{}<",godParty.getId(),r);
                RollDetail rollDetail = new RollDetail();
                rollDetail.setGodPartyId(godParty.getId());
                rollDetail.setRollNum(r);
                rollDetailList.add(rollDetail);
            }
        );
        godPartyDao.saveAll(godPartyList);
        rollDetailDao.saveAll(rollDetailList);
    }

    @Scheduled(cron = "0 3 0 * * ?")
    public void sendMail(){
        List<GodParty> allPartyMinRoll = godPartyDao.getAllPartyMinRoll();
        List<Long> gidList = allPartyMinRoll.stream().map(gp -> gp.getGodId()).collect(Collectors.toList());
        List<God> list = godDao.findAllById(gidList);
        list.stream().forEach(
            god -> {
                Mail mail = new Mail();
                mail.setFrom(env.getProperty("spring.mail.username"));
                mail.setTo(god.getEmail());
                mail.setSubject("1702-ROLL");
                mail.setTemplate("roll");
                Map model = new HashMap();

                mail.setModel(model);
                emailService.sendSimpleMessage(mail);
            }
        );


    }


}