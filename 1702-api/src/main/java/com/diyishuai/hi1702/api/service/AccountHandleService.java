package com.diyishuai.hi1702.api.service;

import com.common.bean.ReturnData;
import com.diyishuai.hi1702.domain.domain.GeneralLedger;
import com.diyishuai.hi1702.domain.domain.GodAccount;

/**
 * 记账处理
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/7/25
 */
public interface AccountHandleService {

    /**
     * 根据条件查询公共账目
     * @return
     */
    ReturnData selectGeneralLedger(GeneralLedger generalLedger);

    /**
     * 根据条件查询个人相关账目
     * @return
     */
    ReturnData selectGodAccount(GodAccount godAccount);

    /**
     * 记录主账目
     * @param generalLedger
     * @return
     */
    ReturnData insertGeneralLedger(GeneralLedger generalLedger);

    /**
     * 支付个人未处理的账目
     * @return
     */
    ReturnData handlePersonal(Integer godId);

    /**
     * 使记录账目失效 （权限操作）
     * @return
     */
    ReturnData invalidateAccountRecord();

}
