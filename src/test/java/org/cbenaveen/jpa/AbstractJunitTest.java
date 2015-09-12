package org.cbenaveen.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

/**
 * Base implementation to be extended by all individual test implementations.
 * 
 * Before each test the class will loads the persistence context. After each
 * test the loaded persistence context will be closed.
 * 
 * @author Naveen Kumar K
 * @email cbenaveen@.gmail.com
 */
public abstract class AbstractJunitTest {

    /**
     * Entity Manager factor instance.
     * 
     * Will be created before every test runs and closed after every test
     * completes.
     */
    private EntityManagerFactory entityManagerFactory = null;

    /**
     * Entity Manager instance.
     * 
     * Will be created before every test runs and closed after every test
     * completes.
     */
    protected EntityManager entityManager = null;

    /**
     * Persistence unit name to be loaded for the test
     */
    private String persistenceUnitName;

    protected AbstractJunitTest(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    /**
     * Creates entity manager factory and entity manager
     */
    @Before
    public void loadPersistenceContext() {
        // load the persistence context
        entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);

        if (entityManagerFactory != null) {
            // create entity manager instance from factory
            entityManager = entityManagerFactory.createEntityManager();
        }
    }

    /**
     * Created entity manager factory and entity manager will be closed
     */
    @After
    public void closePersistenceContext() {
        if (entityManager != null) {
            entityManager.close();
        }

        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
