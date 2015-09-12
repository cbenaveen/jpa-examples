package org.cbenaveen.jpa.examples.composition.one2many.bidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.composition.one2many.bidirectional.Department;
import org.cbenaveen.jpa.composition.one2many.bidirectional.Students;
import org.junit.Test;

public class One2ManyBidirectonalMappingJunitTest extends AbstractJunitTest {
    public One2ManyBidirectonalMappingJunitTest() {
        super("examples.composition.one2many.bidirectonal");
    }

    @Test
    public void test() {
        Department cse = new Department();
        cse.setDepartmentId("cse");
        cse.setDepartmentName("Computer Science and Engineering");

        Students cses1 = new Students();
        cses1.setRollNumber(1l);
        cses1.setName("CSE-S-1");
        cses1.setEmailId("s1@cse.com");
        cses1.setDepartment(cse);

        Students cses2 = new Students();
        cses2.setRollNumber(2l);
        cses2.setName("CSE-S-2");
        cses2.setEmailId("s2@cse.com");
        cses2.setDepartment(cse);

        Students cses3 = new Students();
        cses3.setRollNumber(3l);
        cses3.setName("CSE-S-3");
        cses3.setEmailId("s3@cse.com");
        cses3.setDepartment(cse);

        Set<Students> cseStudents = new HashSet<Students>();
        cseStudents.add(cses1);
        cseStudents.add(cses2);
        cseStudents.add(cses3);

        cse.setStudents(cseStudents);

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(cse);
        tx.commit();

        entityManager.clear();
        Students s = entityManager.find(Students.class, 2l);
        System.out.println("Department Name = "
                + s.getDepartment().getDepartmentName());
    }
}
