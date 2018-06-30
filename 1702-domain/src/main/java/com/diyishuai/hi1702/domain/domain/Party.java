package com.diyishuai.hi1702.domain.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
