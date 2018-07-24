package com.diyishuai.hi1702.api.bean.vo;

import java.io.Serializable;

/**
 * @author Bruce
 * @since 2018/7/24
 */
public class RollInfoVO implements Serializable {

    private String partyName;

    private Integer roll;

    private String rollMinName;

    private Integer rollMin;

    public RollInfoVO() {
    }

    public RollInfoVO(String partyName, Integer roll, String rollMinName, Integer rollMin) {
        this.partyName = partyName;
        this.roll = roll;
        this.rollMinName = rollMinName;
        this.rollMin = rollMin;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getRollMinName() {
        return rollMinName;
    }

    public void setRollMinName(String rollMinName) {
        this.rollMinName = rollMinName;
    }

    public Integer getRollMin() {
        return rollMin;
    }

    public void setRollMin(Integer rollMin) {
        this.rollMin = rollMin;
    }

    @Override
    public String toString() {
        return "RollMailVO{" +
                "partyName='" + partyName + '\'' +
                ", roll=" + roll +
                ", rollMinName='" + rollMinName + '\'' +
                ", rollMin=" + rollMin +
                '}';
    }
}
