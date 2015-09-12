package org.cbenaveen.jpa.examples.embadded;

import static org.junit.Assert.*;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.embadded.Address;
import org.cbenaveen.jpa.embadded.Company;
import org.junit.Test;

public class EmbeddedExplanationJUnitTest extends AbstractJunitTest {

    public EmbeddedExplanationJUnitTest() {
        super("examples.embadded");
    }

    @Test
    public void test() {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Company cisco = new Company();
        cisco.setName("Cisco Systems India Pvt Ltd");
        cisco.setCeoName("Robins");
        cisco.setPrivateLimited(false);
        
        Address ciscoAddress = new Address();
        ciscoAddress.setCity("Bangalore");
        ciscoAddress.setCountry("India");
        ciscoAddress.setState("Karnataka");
        ciscoAddress.setStreet("Marathahalli");
        ciscoAddress.setZipCode("123456");
        
        cisco.setCommunicationAddress(ciscoAddress);
        entityManager.persist(cisco);
        
        Company infoSys = new Company();
        infoSys.setName("Infosys");
        infoSys.setCeoName("NM");
        infoSys.setPrivateLimited(true);
        
        Address infosysAddress = new Address();
        infosysAddress.setCity("Chennai");
        infosysAddress.setCountry("india");
        infosysAddress.setState("Tamilnadu");
        infosysAddress.setStreet("Kanagam Road");
        infosysAddress.setZipCode("600113");
        infoSys.setCommunicationAddress(infosysAddress);
        
        entityManager.persist(infoSys);
        
        tx.commit();
    }
}
