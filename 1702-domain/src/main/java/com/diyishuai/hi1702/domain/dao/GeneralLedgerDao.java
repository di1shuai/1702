package com.diyishuai.hi1702.domain.dao;

import com.diyishuai.hi1702.domain.domain.GeneralLedger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralLedgerDao extends JpaRepository<GeneralLedger, Long>{

}
