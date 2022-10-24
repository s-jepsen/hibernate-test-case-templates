package org.hibernate.bugs.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
