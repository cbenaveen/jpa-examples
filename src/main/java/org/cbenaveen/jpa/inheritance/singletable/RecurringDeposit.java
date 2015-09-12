package org.cbenaveen.jpa.inheritance.singletable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("RD")
public class RecurringDeposit extends DepositAccount {

    @Column(name = "MONTHLY_RECURRING_AMOUNT")
    private double recurringAmount;

    @Column(name = "DEPOSIT_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public double getRecurringAmount() {
        return recurringAmount;
    }

    public void setRecurringAmount(double recurringAmount) {
        this.recurringAmount = recurringAmount;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
