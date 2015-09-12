package org.cbenaveen.jpa.examples.idgeneration;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.idgeneration.EmployeeGenUsinCustomSequence;
import org.junit.Test;

public class EntityIDGenerationUsinCustomSequenceTechniquesJUnitTest extends
        AbstractJunitTest {

    public EntityIDGenerationUsinCustomSequenceTechniquesJUnitTest() {
        super("examples.idgeneration");
    }

    @Test
    public void testIDGenerationUsingCustomSequence() {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        for (int i = 0; i < 200; i++) {
            entityManager.persist(new EmployeeGenUsinCustomSequence());
            
            if(i % 5 == 0){
                tx.commit();    
                tx = entityManager.getTransaction();
                tx.begin();
            }
        }

        tx.commit();
    }
}
