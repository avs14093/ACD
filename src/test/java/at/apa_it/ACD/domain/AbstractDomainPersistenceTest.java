package at.apa_it.ACD.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractDomainPersistenceTest {
	
	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ACDPU");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void teardown() {
        if (entityManager != null) {
            entityManager.getTransaction().commit();
        }
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    protected EntityManager entityManager() {
        return entityManager;
    }
}
