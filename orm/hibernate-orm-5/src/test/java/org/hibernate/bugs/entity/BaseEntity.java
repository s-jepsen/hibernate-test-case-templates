package org.hibernate.bugs.entity;

import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof BaseEntity) {
            BaseEntity other = (BaseEntity) o;
            if(getClass() == other.getClass()) {
                return id != null && id.equals(other.id);
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}