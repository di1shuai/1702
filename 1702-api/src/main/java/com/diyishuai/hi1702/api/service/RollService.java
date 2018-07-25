package com.diyishuai.hi1702.api.service;

import com.diyishuai.hi1702.domain.dao.GodPartyDao;
import com.diyishuai.hi1702.domain.dao.PartyDao;
import com.diyishuai.hi1702.domain.dao.RollDetailDao;
import com.diyishuai.hi1702.domain.domain.GodParty;
import com.diyishuai.hi1702.domain.domain.Party;
import com.diyishuai.hi1702.domain.domain.RollDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Bruce
 * @since 2018/7/3
 */
@Service
public class RollService {

    @Autowired
    private GodPartyDao godPartyDao;

    @Autowired
    private RollDetailDao rollDetailDao;

    public void rollNow(){
        Date date = new Date();
        List<RollDetail> rollDetailList = new ArrayList<>();
        List<GodParty> godPartyList = godPartyDao.findAll();

        godPartyList.forEach( godParty -> {
            Random random = new Random();
            Integer r = random.nextInt(101);
            godParty.setRollTaday(r);
            godParty.setUpdateTime(date);

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
