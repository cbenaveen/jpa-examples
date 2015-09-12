package org.cbenaveen.jpa.inheritance.jointable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ACCOUNT_TYPE")
public abstract class BankAccount {
    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private long accountNumber;
    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String name;
    @Column(name = "ACCOUNT_HOLDER_EMAILID")
    private String emailId;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
