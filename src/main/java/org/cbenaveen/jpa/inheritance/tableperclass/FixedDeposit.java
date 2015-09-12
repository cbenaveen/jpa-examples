package org.cbenaveen.jpa.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("FD")
public class FixedDeposit extends DepositAccount {

    @Column(name = "DEPOSIT_AMOUNT")
    private double depositAmount;

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }
}
