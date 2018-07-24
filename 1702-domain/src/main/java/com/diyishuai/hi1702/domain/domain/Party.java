package com.diyishuai.hi1702.domain.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    public Party() {
    }

    public Party(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
