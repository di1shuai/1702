package com.diyishuai.hi1702.domain.dao;

import com.diyishuai.hi1702.domain.domain.GodAccount;
import com.diyishuai.hi1702.domain.vo.GodAccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GodAccountDao extends JpaRepository<GodAccount, Long>{

    /**
     * 查询个人的账目详情信息
     * @return
     */
    List<GodAccountDetail> selectGodAccountDetail();

}
