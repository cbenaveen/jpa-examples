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
@Table(name = "ORGANIZATION_INFORMATION_WITH_CUSTOM_COLUMNS_FOR_ADDRESS")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ORG_ID")
    private long id;

    @Column(name = "ORG_NAME")
    private String name;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street", column = @Column(name = "ORG_STREET")),
        @AttributeOverride(name="city", column = @Column(name = "ORG_CITY")),
        @AttributeOverride(name="state", column = @Column(name = "ORG_STATE")),
        @AttributeOverride(name="country", column = @Column(name = "ORG_COUNTRY")),
        @AttributeOverride(name="zipCode", column = @Column(name = "ORG_ZIPCODE")),
    })
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
}
