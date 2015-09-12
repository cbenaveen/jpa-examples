package org.cbenaveen.jpa.examples.idgeneration;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.idgeneration.Students;
import org.cbenaveen.jpa.idgeneration.Teachers;
import org.junit.Test;

public class EntityIDGenerationUsinTableGeneratorTechniquesJUnitTest extends
        AbstractJunitTest {

    public EntityIDGenerationUsinTableGeneratorTechniquesJUnitTest() {
        super("examples.idgeneration.table");
    }

     @Test
    public void testIDGenerationUsingAuto() {
         EntityTransaction tx = entityManager.getTransaction();
         tx.begin();

         for (int i = 0; i < 200; i++) {
             entityManager.persist(new Students());
             entityManager.persist(new Teachers());
             
//             if(i % 5 == 0){
//                 tx.commit();    
//                 tx = entityManager.getTransaction();
//                 tx.begin();
//             }
         }

         tx.commit();
    }
}
