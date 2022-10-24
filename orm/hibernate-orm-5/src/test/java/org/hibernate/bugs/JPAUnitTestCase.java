package org.hibernate.bugs;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import org.hibernate.bugs.entity.DefinitionA;
import org.hibernate.bugs.entity.Organization;
import org.hibernate.bugs.entity.PhysicalAspect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    public void hhh15622Test() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // setup
        entityManager.getTransaction().begin();

        Organization organization = new Organization("myOrg");
        entityManager.persist(organization);

        PhysicalAspect physicalAspect = new PhysicalAspect(organization);
        entityManager.persist(physicalAspect);

        DefinitionA definitionA = new DefinitionA(physicalAspect);
        definitionA.setModuleWidth(10);
        entityManager.persist(definitionA);

        physicalAspect.setDefinition(definitionA);

        entityManager.flush();

        // fetch
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PhysicalAspect> query = cb.createQuery(PhysicalAspect.class);
        Root<PhysicalAspect> aspect = query.from(PhysicalAspect.class);
        Path<String> organizationPath = aspect.get("organization");

        EntityGraph<?> graph = entityManager.getEntityGraph("Item.characteristics");
        CriteriaQuery<PhysicalAspect> where = query
                .select(aspect)
                .where(cb.equal(organizationPath, organization));

        entityManager.createQuery(where).setHint("javax.persistence.fetchgraph", graph).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}