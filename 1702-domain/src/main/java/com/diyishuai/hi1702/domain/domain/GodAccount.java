package com.diyishuai.hi1702.domain.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 个人账目
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/7/25
 */
@Entity
@Table(name = "god_account")
public class GodAccount {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint(20)")
    private Integer id;

    /**
     * 当前使用人
     */
    @Column(name = "user_id",columnDefinition = "bigint(20)")
    private Integer userId;

    /**
     * 花费时间
     */
    @Column(name = "spend_time",columnDefinition = "datetime")
    private Date spendTime;

    /**
     * 关联主账目id
     */
    @Column(name = "general_id", columnDefinition = "bigint(20)")
    private Integer generalId;

    /**
     *状态  0：待处理  1：已处理
     */
    @Column
    private Byte status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Date spendTime) {
        this.spendTime = spendTime;
    }

    public Integer getGeneralId() {
        return generalId;
    }

    public void setGeneralId(Integer generalId) {
        this.generalId = generalId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
