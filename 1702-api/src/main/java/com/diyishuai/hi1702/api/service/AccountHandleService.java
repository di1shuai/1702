package com.diyishuai.hi1702.api.service;

import com.common.bean.ReturnData;
import com.diyishuai.hi1702.domain.domain.GeneralLedger;

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
    ReturnData selectGeneralLedgerByPage();

    /**
     * 查询个人相关账目
     * @return
     */
    ReturnData selectGodAccountByPage();

    /**
     * 记录账目
     * @param generalLedger
     * @return
     */
    ReturnData insertGeneralLedger(GeneralLedger generalLedger);

    ReturnData invalidateAccountRecord();

}
