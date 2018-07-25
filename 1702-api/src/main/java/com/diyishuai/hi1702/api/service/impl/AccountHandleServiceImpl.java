package com.diyishuai.hi1702.api.service.impl;

import com.common.bean.ReturnData;
import com.diyishuai.hi1702.api.service.AccountHandleService;
import com.diyishuai.hi1702.domain.dao.GeneralLedgerDao;
import com.diyishuai.hi1702.domain.dao.GodAccountDao;
import com.diyishuai.hi1702.domain.domain.GeneralLedger;
import com.diyishuai.hi1702.domain.domain.GodAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountHandleService")
public class AccountHandleServiceImpl implements AccountHandleService{

    @Autowired
    private GeneralLedgerDao generalLedgerDao;

    @Autowired
    private GodAccountDao godAccountDao;

    @Override
    public ReturnData selectGeneralLedger(GeneralLedger generalLedger) {
        return null;
    }

    @Override
    public ReturnData selectGodAccount(GodAccount godAccount) {
        return null;
    }

    @Override
    public ReturnData insertGeneralLedger(GeneralLedger generalLedger) {
        return null;
    }

    @Override
    public ReturnData invalidateAccountRecord() {
        return null;
    }
}
