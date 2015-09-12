package org.cbenaveen.jpa.examples.composition.one2one.bidirectional;

import java.util.Calendar;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.composition.one2one.bidirectonal.Course;
import org.cbenaveen.jpa.composition.one2one.bidirectonal.Instructor;
import org.junit.Test;

public class One2OneBidirectionalMappingJunitTest extends AbstractJunitTest{
    public One2OneBidirectionalMappingJunitTest() {
        super("examples.composition.one2one.bidirectional");
    }

    @Test
    public void test(){
        Instructor instructor = new Instructor();
        instructor.setName("Naveen kumar");
        instructor.setAge(33);
        
        Calendar calendar = Calendar.getInstance();
        
        Course java = new Course();
        java.setCourseName("Java SE");
        java.setStartDate(calendar.getTime());
        //increase by 1 month
        calendar.add(Calendar.MONTH, 1);
        java.setEndDate(calendar.getTime());
        java.setInstructor(instructor);
        instructor.setCourse(java);
        
        Course jpa = new Course();
        jpa.setCourseName("JPA");
        jpa.setStartDate(calendar.getTime());
        //increase by 1 month
        calendar.add(Calendar.MONTH, 1);
        jpa.setEndDate(calendar.getTime());
        jpa.setInstructor(instructor);
        instructor.setCourse(jpa);
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(java);
        entityManager.persist(jpa);
        tx.commit();
        
        tx = entityManager.getTransaction();
        tx.begin();
        Instructor aInstructor = entityManager.find(Instructor.class, 1l);
        System.out.println(aInstructor.getName() + " teaches " + aInstructor.getCourse().getCourseName());
        tx.rollback();
    }
}
