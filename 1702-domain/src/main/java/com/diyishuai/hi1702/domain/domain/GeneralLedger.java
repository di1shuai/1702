package com.diyishuai.hi1702.domain.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 总账目表
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/7/25
 */
@Entity
@Table(name = "general_leger" )
public class GeneralLedger {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint(20)")
    private Integer id;

    /**
     * 人员id
     */
    @Column(name = "god_id", columnDefinition = "bigint(20)")
    private Integer godId;

    /**
     * 花销
     */
    @Column(name = "money", columnDefinition = "decimal(10,2)")
    private BigDecimal money;

    /**
     *费用产生时间
     */
    @Column(name = "use_time", columnDefinition = "datetime")
    private Date useTime;

    /**
     *分摊状态  0：不需要分摊  1：未分摊  2：已分摊
     */
    @Column(name = "is_share")
    private Byte isShare;

    /**
     * 消费处理策略 0：均分  1：指向（借款）
     */
    @Column(name = "strategy")
    private Byte strategy;

    /**
     * 账目类型：0：消费  1：借款
     */
    @Column(name = "type")
    private Byte type;

    /**
     * 处理完成时间  如果是不分摊状态  该时间和费用产生时间一致
     */
    @Column(name = "handle_time", columnDefinition = "datetime")
    private Date handleTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

}
