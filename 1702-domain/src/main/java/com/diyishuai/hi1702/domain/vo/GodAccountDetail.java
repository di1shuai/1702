package com.diyishuai.hi1702.domain.vo;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 个人账户详情
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/7/26
 */
public class GodAccountDetail {


    private Integer id;

    /**
     * 当前使用人
     */
    private Integer userId;

    /**
     * 花费时间
     */
    private Date spendTime;

    /**
     * 个人花销
     */
    private BigDecimal personalCost;

    /**
     * 人员id
     */
    private Integer godId;

    /**
     * 花销
     */
    private BigDecimal money;

    /**
     *费用产生时间
     */
    private Date useTime;

    /**
     *分摊状态  0：不需要分摊  1：未分摊  2：已分摊
     */
    private Byte isShare;

    /**
     * 消费处理策略 0：均分  1：指向（借款）
     */
    private Byte strategy;

    /**
     * 账目类型：0：消费  1：借款
     */
    private Byte type;

    /**
     * 是否是有效  0：失效  1：有效
     */
    private Byte isValid;

    /**
     * 参与者
     */
    private String participant;


    /**
     * 处理完成时间  如果是不分摊状态  该时间和费用产生时间一致
     */
    private Date handleTime;

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

    public BigDecimal getPersonalCost() {
        return personalCost;
    }

    public void setPersonalCost(BigDecimal personalCost) {
        this.personalCost = personalCost;
    }

    public Integer getGodId() {
        return godId;
    }

    public void setGodId(Integer godId) {
        this.godId = godId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Byte getIsShare() {
        return isShare;
    }

    public void setIsShare(Byte isShare) {
        this.isShare = isShare;
    }

    public Byte getStrategy() {
        return strategy;
    }

    public void setStrategy(Byte strategy) {
        this.strategy = strategy;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}
