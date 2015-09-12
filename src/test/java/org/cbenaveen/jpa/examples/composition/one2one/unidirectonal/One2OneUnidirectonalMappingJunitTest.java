package org.cbenaveen.jpa.examples.composition.one2one.unidirectonal;

import java.util.Calendar;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.composition.one2one.unidirectonal.Course;
import org.cbenaveen.jpa.composition.one2one.unidirectonal.Instructor;
import org.junit.Test;

public class One2OneUnidirectonalMappingJunitTest extends AbstractJunitTest{
    public One2OneUnidirectonalMappingJunitTest() {
        super("examples.composition.one2one.unidirectonal");
    }

    @Test
    public void test(){
        Instructor instructor = new Instructor();
        instructor.setName("Naveen kumar JPA Instructor");
        instructor.setAge(33);
        
        Calendar calendar = Calendar.getInstance();
        
        Course java = new Course();
        java.setCourseName("JPA SE, by Naveen Kumar");
        java.setStartDate(calendar.getTime());
        //increase by 1 month
        calendar.add(Calendar.MONTH, 1);
        java.setEndDate(calendar.getTime());
        java.setInstructor(instructor);
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(java);
        tx.commit();
        
        entityManager.clear();
        tx = entityManager.getTransaction();
        tx.begin();
        
        //fetch the cours by id
        Course javaCourse = entityManager.find(Course.class, java.getCourseId());
        System.out.println("Course name is = " + javaCourse.getCourseName());
        System.out.println("Thought by = " + javaCourse.getInstructor().getName());
        tx.rollback();
    }
}
