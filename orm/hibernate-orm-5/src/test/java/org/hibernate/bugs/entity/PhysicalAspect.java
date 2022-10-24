package org.hibernate.bugs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
