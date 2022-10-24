package org.hibernate.bugs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "definitionA")
public class DefinitionA extends PhysicalAspectDefinition {

    protected DefinitionA() {
    }

    public DefinitionA(PhysicalAspect physicalAspect) {
        super(physicalAspect);
    }

    @Column(name = "module_width")
    private Integer moduleWidth;

    public void setModuleWidth(Integer moduleWidth) {
        this.moduleWidth = moduleWidth;
    }

}