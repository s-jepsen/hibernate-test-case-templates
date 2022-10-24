package org.hibernate.bugs.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
@DiscriminatorColumn(length = 64)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PhysicalAspectDefinition extends OrganizationBaseEntity {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_id", nullable = false, updatable = false)
    private PhysicalAspect physicalAspect;

    protected PhysicalAspectDefinition() {
    }

    protected PhysicalAspectDefinition(PhysicalAspect physicalAspect) {
        super(physicalAspect.getOrganization());
        this.physicalAspect = physicalAspect;
    }

}
