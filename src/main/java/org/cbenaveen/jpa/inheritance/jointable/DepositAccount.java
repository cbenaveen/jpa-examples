package org.cbenaveen.jpa.inheritance.jointable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class DepositAccount extends BankAccount{

    @Column(name = "DEPOSIT_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
