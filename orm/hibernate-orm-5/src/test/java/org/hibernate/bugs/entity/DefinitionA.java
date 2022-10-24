package org.hibernate.bugs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

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