package org.cbenaveen.jpa.examples.idgeneration;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.idgeneration.Employee;
import org.junit.Test;

public class EntityIDGenerationUsinAutoTechniquesJUnitTest extends
        AbstractJunitTest {

    public EntityIDGenerationUsinAutoTechniquesJUnitTest() {
        super("examples.idgeneration");
    }

     @Test
    public void testIDGenerationUsingAuto() {
         EntityTransaction tx = entityManager.getTransaction();
         tx.begin();

         for (int i = 0; i < 200; i++) {
             entityManager.persist(new Employee());
             
             if(i % 5 == 0){
                 tx.commit();    
                 tx = entityManager.getTransaction();
                 tx.begin();
             }
         }

         tx.commit();
    }
}
