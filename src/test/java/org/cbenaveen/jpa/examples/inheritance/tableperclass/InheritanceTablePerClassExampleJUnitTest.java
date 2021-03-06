package org.cbenaveen.jpa.examples.inheritance.tableperclass;

import java.util.Calendar;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.inheritance.tableperclass.CurrentAccount;
import org.cbenaveen.jpa.inheritance.tableperclass.FixedDeposit;
import org.cbenaveen.jpa.inheritance.tableperclass.RecurringDeposit;
import org.cbenaveen.jpa.inheritance.tableperclass.SavingsAccount;
import org.junit.Test;

public class InheritanceTablePerClassExampleJUnitTest extends AbstractJunitTest{
    public InheritanceTablePerClassExampleJUnitTest() {
        super("examples.composition.inheritance.tableperclass");
    }
    
    @Test
    public void test(){
        SavingsAccount sa = new SavingsAccount();
        sa.setAccountNumber(1l);
        sa.setEmailId("abc@abc.com");
        sa.setInterestRate(4.34);
        sa.setName("SavingAccount Holder");
        
        CurrentAccount ca = new CurrentAccount();
        ca.setAccountNumber(2l);
        ca.setEmailId("qwe@qwe.com");
        ca.setName("CurrentAccount Holder");
        ca.setServiceCharges(12);
        
        Calendar cal = Calendar.getInstance();
        RecurringDeposit rd = new RecurringDeposit();
        rd.setAccountNumber(3l);
        rd.setEmailId("qaz@qaz.com");
        rd.setStartDate(cal.getTime());
        cal.set(Calendar.YEAR, 1);
        rd.setEndDate(cal.getTime());
        rd.setName("RecurringDeposit Holder");
        rd.setRecurringAmount(5000.00);
        
        FixedDeposit fd = new FixedDeposit();
        fd.setAccountNumber(4l);
        fd.setDepositAmount(500000.50);
        fd.setEmailId("ert@ert.com");
        fd.setName("FixedDeposit Holder");
        cal = Calendar.getInstance();
        fd.setStartDate(cal.getTime());
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(sa);
        entityManager.persist(ca);
        entityManager.persist(rd);
        entityManager.persist(fd);
        tx.commit();
    }
}
