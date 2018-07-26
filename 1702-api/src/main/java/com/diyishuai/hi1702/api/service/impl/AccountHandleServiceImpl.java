package com.diyishuai.hi1702.api.service.impl;


import com.common.bean.CommonConstant;
import com.common.bean.ReturnData;
import com.diyishuai.hi1702.api.service.AccountHandleService;
import com.diyishuai.hi1702.domain.dao.GeneralLedgerDao;
import com.diyishuai.hi1702.domain.dao.GodAccountDao;
import com.diyishuai.hi1702.domain.domain.GeneralLedger;
import com.diyishuai.hi1702.domain.domain.GodAccount;
import com.diyishuai.hi1702.domain.vo.GodAccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountHandleService")
public class AccountHandleServiceImpl implements AccountHandleService{

    @Autowired
    private GeneralLedgerDao generalLedgerDao;

    @Autowired
    private GodAccountDao godAccountDao;

    @Override
    public ReturnData selectGeneralLedger(GeneralLedger generalLedger) {

        ReturnData returnData = new ReturnData();
        returnData.setRetCode(CommonConstant.RETURN_CODE_FAIL);

        /**
         * 查询条件 默认为有效的记录
         */
        if (null == generalLedger.getIsValid()){
            generalLedger.setIsValid(CommonConstant.VALIS_STATUS_YES);
        }

        /**
         * 参与者
         */
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("participant", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<GeneralLedger> generalLedgerExample = Example.of(generalLedger, matcher);

        Sort sort = new Sort(Sort.Direction.DESC, "user_time");

        List<GeneralLedger> recods = generalLedgerDao.findAll(generalLedgerExample, sort);

        returnData.setData(recods);
        returnData.setRetCode(CommonConstant.RETURN_CODE_SUCCESS);
        return returnData;
    }

    @Override
    public ReturnData selectGodAccount(GodAccount godAccount) {

        ReturnData returnData = new ReturnData();
        returnData.setRetCode(CommonConstant.RETURN_CODE_FAIL);

        List<GodAccountDetail> godAccountDtails = godAccountDao.selectGodAccountDetail();

        returnData.setData(godAccountDtails);
        returnData.setRetCode(CommonConstant.RETURN_CODE_SUCCESS);
        return returnData;
    }

    @Override
    public ReturnData insertGeneralLedger(GeneralLedger generalLedger) {

        ReturnData returnData = new ReturnData();
        returnData.setRetCode(CommonConstant.RETURN_CODE_FAIL);

        //插入主账目信息

        //插入个人账目信息


        returnData.setRetCode(CommonConstant.RETURN_CODE_SUCCESS);
        return null;
    }

    @Override
    public ReturnData handlePersonal(Integer godId) {
        ReturnData returnData = new ReturnData();
        returnData.setRetCode(CommonConstant.RETURN_CODE_FAIL);

        //修改个人账目状态

        returnData.setRetCode(CommonConstant.RETURN_CODE_SUCCESS);
        return null;
    }

    @Override
    public ReturnData invalidateAccountRecord() {
        ReturnData returnData = new ReturnData();
        returnData.setRetCode(CommonConstant.RETURN_CODE_FAIL);

        //修改主账目状态为无效

        returnData.setRetCode(CommonConstant.RETURN_CODE_SUCCESS);
        return null;
    }


}
