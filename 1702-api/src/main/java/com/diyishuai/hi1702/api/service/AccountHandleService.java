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
     * 查询公共账目
     * @return
     */
    ReturnData selectGeneralLedger(GeneralLedger generalLedger);

    /**
     * 查询个人相关账目
     * @return
     */
    ReturnData selectGodAccount(GodAccount godAccount);

    /**
     * 记录账目
     * @param generalLedger
     * @return
     */
    ReturnData insertGeneralLedger(GeneralLedger generalLedger);

    /**
     * 使记录账目失效 （权限操作）
     * @return
     */
    ReturnData invalidateAccountRecord();

}
