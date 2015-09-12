package org.cbenaveen.jpa.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("CURRENT")
public class CurrentAccount extends BankAccount {

    @Column(name = "SERVICE_CHARGE")
    private double serviceCharges;

    public double getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(double serviceChanrges) {
        this.serviceCharges = serviceChanrges;
    }
}
