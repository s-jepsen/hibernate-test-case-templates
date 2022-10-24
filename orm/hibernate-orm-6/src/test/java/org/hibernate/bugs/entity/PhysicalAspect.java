package org.hibernate.bugs.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@NamedEntityGraph(name = "Item.characteristics",
        attributeNodes = @NamedAttributeNode("definition")
)
@Entity
@Table
public class PhysicalAspect extends OrganizationBaseEntity {

    @OneToOne(mappedBy = "physicalAspect", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private PhysicalAspectDefinition definition;

    protected PhysicalAspect() {
    }

    public PhysicalAspect(Organization organization) {
        super(organization);
    }

    public void setDefinition(PhysicalAspectDefinition definition) {
        this.definition = definition;
    }

}
