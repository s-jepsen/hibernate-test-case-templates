package org.hibernate.bugs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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