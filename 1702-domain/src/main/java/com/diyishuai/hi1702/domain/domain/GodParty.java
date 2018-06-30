package com.diyishuai.hi1702.domain.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@Table(name = "god_party")
public class GodParty {

    @Id
    @GeneratedValue
    protected Long id;
    @Column(name = "god_id")
    protected Long godId;
    @Column(name = "party_id")
    protected Long partyId;
    @Column(name = "roll_taday")
    protected Integer rollTaday;
    @Column(name = "create_time")
    protected Date createTime;
    @Column(name = "update_time")
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGodId() {
        return godId;
    }

    public void setGodId(Long godId) {
        this.godId = godId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Integer getRollTaday() {
        return rollTaday;
    }

    public void setRollTaday(Integer rollTaday) {
        this.rollTaday = rollTaday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
