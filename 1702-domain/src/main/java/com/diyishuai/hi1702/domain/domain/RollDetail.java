package com.diyishuai.hi1702.domain.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@Table(name = "roll_detail")
public class RollDetail {

    @Id
    @GeneratedValue
    protected Long id;
    @Column(name = "god_party_id")
    protected Long godPartyId;
    @Column(name = "roll_num")
    protected Integer rollNum;
    @Column(name = "create_time")
    protected Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGodPartyId() {
        return godPartyId;
    }

    public void setGodPartyId(Long godPartyId) {
        this.godPartyId = godPartyId;
    }

    public Integer getRollNum() {
        return rollNum;
    }

    public void setRollNum(Integer rollNum) {
        this.rollNum = rollNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
