package com.diyishuai.hi1702.domain.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "god")
public class God {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    protected String email;

    public God() {
    }

    public God(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "God{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
