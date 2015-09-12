package org.cbenaveen.jpa.embadded;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZATION_INFORMATION")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ORG_ID")
    private long id;

    @Column(name = "ORG_NAME")
    private String name;
    
    @Column(name = "ORG_IS_PRIVATE_LIMITED")
    private boolean privateLimited;
    
    @Column(name = "ORG_CEO_NAME")
    private String ceoName;

    @Embedded
    private Address communicationAddress;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isPrivateLimited() {
        return privateLimited;
    }

    public void setPrivateLimited(boolean privateLimited) {
        this.privateLimited = privateLimited;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }
}
