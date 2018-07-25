package com.diyishuai.hi1702.api.service.impl;

import com.diyishuai.hi1702.domain.dao.GeneralLedgerDao;
import com.diyishuai.hi1702.domain.dao.GodAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountHandleService")
public class AccountHandleServiceImpl {

    @Autowired
    private GeneralLedgerDao generalLedgerDao;

    @Autowired
    private GodAccountDao godAccountDao;





}
