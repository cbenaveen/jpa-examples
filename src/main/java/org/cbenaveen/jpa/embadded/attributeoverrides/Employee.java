package org.cbenaveen.jpa.embadded.attributeoverrides;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFORMATION_WITH_CUSTOM_COLUMNS_FOR_ADDRESS")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "EMP_ID")
    private long id;

    @Column(name = "EMP_NAME")
    private String name;
    
    @Column(name = "EMP_EMAIL_ID")
    private String emailId;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street", column = @Column(name = "EMP_STREET")),
        @AttributeOverride(name="city", column = @Column(name = "EMP_CITY")),
        @AttributeOverride(name="state", column = @Column(name = "EMP_STATE")),
        @AttributeOverride(name="country", column = @Column(name = "EMP_COUNTRY")),
        @AttributeOverride(name="zipCode", column = @Column(name = "EMP_ZIPCODE")),
    })
    private Address communicationAddress;
    
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
    
    public Address getCommunicationAddress() {
        return communicationAddress;
    }

    public void setCommunicationAddress(Address communicationAddress) {
        this.communicationAddress = communicationAddress;
    }

    public long getId() {
        return id;
    }
}
