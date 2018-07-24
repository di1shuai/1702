package com.diyishuai.hi1702.domain.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "god_party")
public class GodParty implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "god_id")
    protected God god;

    @ManyToOne
    @JoinColumn(name = "party_id")
    protected Party party;

    @Column(name = "roll_taday")
    protected Integer rollTaday;
    @CreatedDate
    @Column(name = "create_time")
    protected Date createTime;
    @LastModifiedDate
    @Column(name = "update_time")
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public God getGod() {
        return god;
    }

    public void setGod(God god) {
        this.god = god;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "GodParty{" +
                "id=" + id +
//                ", god=" + god +
//                ", party=" + party +
                ", rollTaday=" + rollTaday +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
