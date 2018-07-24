package com.diyishuai.hi1702.api.scheduler;

import com.diyishuai.hi1702.api.bean.vo.RollInfoVO;
import com.diyishuai.hi1702.domain.dao.GodDao;
import com.diyishuai.hi1702.domain.dao.GodPartyDao;
import com.diyishuai.hi1702.domain.dao.RollDetailDao;
import com.diyishuai.hi1702.domain.domain.God;
import com.diyishuai.hi1702.domain.domain.GodParty;
import com.diyishuai.hi1702.domain.domain.Party;
import com.diyishuai.hi1702.domain.domain.RollDetail;
import com.diyishuai.hi1702.mail.bean.Mail;
import com.diyishuai.hi1702.mail.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

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
        List<God> godList = godDao.findAll();
        List<GodParty> allPartyMinRoll = godPartyDao.getAllPartyMinRoll();

        godList.stream().forEach(
            god -> {
                Mail mail = new Mail();
                mail.setFrom(env.getProperty("spring.mail.username"));
                mail.setTo(god.getEmail());
                mail.setSubject("[ROLL]1702");
                mail.setTemplate("roll");

                List<RollInfoVO> rollInfoVOList = new ArrayList<>();
                Map model = new HashMap();
                Set<GodParty> godPartySet = god.getGodPartySet();
                godPartySet.stream().forEach(
                        godParty -> {
                            Party party = godParty.getParty();
                            String partyName = party.getName();
                            Integer roll = godParty.getRollTaday();
                            GodParty minGP = allPartyMinRoll
                                    .stream()
                                    .findAny()
                                    .filter(gp -> gp.getParty().getId() == party.getId())
                                    .get();
                            String rollMinName = minGP.getGod().getName();
                            Integer rollMin = minGP.getRollTaday();
                            rollInfoVOList.add(new RollInfoVO(partyName,roll,rollMinName,rollMin));
                        }
                );
                model.put("name",god.getName());
                model.put("rollInfoList",rollInfoVOList);
                mail.setModel(model);
                emailService.sendSimpleMessage(mail);
            }
        );

    }


}