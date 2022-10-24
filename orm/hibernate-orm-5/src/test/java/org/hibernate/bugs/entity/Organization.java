package org.hibernate.bugs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Organization extends BaseEntity {

    @Column(name = "name", length = 128)
    private String orgName;

    protected Organization() {
    }

    public Organization(String orgName) {
        this.orgName = orgName;
    }

}