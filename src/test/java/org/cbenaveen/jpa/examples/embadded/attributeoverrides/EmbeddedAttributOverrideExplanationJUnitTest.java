package org.cbenaveen.jpa.examples.embadded.attributeoverrides;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.embadded.attributeoverrides.Address;
import org.cbenaveen.jpa.embadded.attributeoverrides.Company;
import org.cbenaveen.jpa.embadded.attributeoverrides.Employee;
import org.junit.Test;

public class EmbeddedAttributOverrideExplanationJUnitTest extends AbstractJunitTest {

    public EmbeddedAttributOverrideExplanationJUnitTest() {
        super("examples.embadded.attributeoverrides");
    }

    @Test
    public void test() {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Company cisco = new Company();
        cisco.setName("Cisco Systems India Pvt Ltd");
        
        Address ciscoAddress = new Address();
        ciscoAddress.setCity("Bangalore");
        ciscoAddress.setCountry("India");
        ciscoAddress.setState("Karnataka");
        ciscoAddress.setStreet("Marathahalli");
        ciscoAddress.setZipCode("123456");
        
        cisco.setCommunicationAddress(ciscoAddress);
        entityManager.persist(cisco);
        
        Company infosys = new Company();
        infosys.setName("Infosys");
        
        Address infosysAddress = new Address();
        infosysAddress.setCity("Bangalore");
        infosysAddress.setCountry("india");
        infosysAddress.setState("Karnataka");
        infosysAddress.setStreet("Electronic City");
        infosysAddress.setZipCode("987654");
        infosys.setCommunicationAddress(infosysAddress);
        
        entityManager.persist(infosys);
        
        Address naveenAddress = new Address();
        naveenAddress.setCity("Chennai");
        naveenAddress.setCountry("india");
        naveenAddress.setState("Tamilnadu");
        naveenAddress.setStreet("Kanagam Road");
        naveenAddress.setZipCode("600113");
        
        Employee naveen = new Employee();
        naveen.setEmailId("cbenaveen@gmail.com");
        naveen.setName("Naveen Kumar");
        naveen.setCommunicationAddress(naveenAddress);
        entityManager.persist(naveen);
        
        tx.commit();
    }
}
