package com.diyishuai.hi1702.domain.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Bruce
 * @since 2018/6/30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "god")
public class God implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    protected String email;

    @JsonIgnoreProperties(value = { "god","party" })
    @OneToMany(mappedBy = "god",cascade = CascadeType.ALL)
    protected Set<GodParty> godPartySet;

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

    public Set<GodParty> getGodPartySet() {
        return godPartySet;
    }

    public void setGodPartySet(Set<GodParty> godPartySet) {
        this.godPartySet = godPartySet;
    }

    @Override
    public String toString() {
        return "God{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", godPartySet=" + godPartySet +
                '}';
    }
}
