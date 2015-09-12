package org.cbenaveen.jpa.examples.annotations;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.annotations.Users;
import org.junit.Test;

public class BasicAnnotationsExampleJUnitTest extends AbstractJunitTest {

    public BasicAnnotationsExampleJUnitTest() {
        super("examples.annotations");
    }

    @Test
    public void createUserTest() {

        /**
         * Create an Users Entity
         */
        Users naveen = new Users(10);
        naveen.setFirstName("Naveen");
        naveen.setLastName("Kumar");
        naveen.setEmailId("cbenaveen@gmail.com");
        naveen.setSex("Male");
        naveen.setAge(33);

        // Begin your transaction
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // Save the created entity
        entityManager.persist(naveen);

        // Flush so that data will be moved to DB from memory
//        entityManager.flush();

        // Flush so that data will be moved to DB from memory
        tx.commit();
    }

    @Test
    public void createUserAndReadeItFromRDBMS() {
        /**
         * Create an Users Entity
         */
        Users naveen = new Users(1);
        naveen.setFirstName("Naveen");
        naveen.setLastName("Kumar");
        naveen.setEmailId("cbenaveen@gmail.com");
        naveen.setSex("Male");
        naveen.setAge(33);

        // Begin your transcation
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // Save the created entity
        entityManager.persist(naveen);

        // Flush so that data will be moved to DB from memory
        entityManager.flush();

        // Flush so that data will be moved to DB from memory
        tx.commit();

        tx = entityManager.getTransaction();
        tx.begin();
        Users user = entityManager.find(Users.class, 1);
        
        /**
         * if JPA unable to find an entity with the given primary key,
         * then a null object will be returned
         */
        if(user != null){
            StringBuffer buffer = new StringBuffer();
            buffer.append("User Information: [Id: " + user.getId());
            buffer.append(", First Name: " + user.getFirstName());
            buffer.append(", Last Name: " + user.getLastName());
            buffer.append(", Email ID: " + user.getEmailId());
            buffer.append(", Age: " + user.getAge());
            buffer.append(", Sex: " + user.getSex());
            buffer.append("]");
            
            System.out.println(buffer.toString());
        } else {
            System.err.println("User not found !!!");
        }
        tx.rollback();
    }
}
