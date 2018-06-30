package com.diyishuai.hi1702.domain.dao;

import com.diyishuai.hi1702.domain.domain.God;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GodDao extends JpaRepository<God, Long> {

	Page<God> findAll(Pageable pageable);
}