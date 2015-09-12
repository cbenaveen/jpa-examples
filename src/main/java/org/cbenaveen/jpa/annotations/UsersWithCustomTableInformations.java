package org.cbenaveen.jpa.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_SESSION_USERS")
public class UsersWithCustomTableInformations {
    
    @Id
    @Column(name = "C_USER_ID")
    private int id;
    
    @Column(name = "C_USER_FIRST_NAME", length = 500, nullable = false)
    private String firstName;
    
    @Column(name = "C_USER_LAST_NAME", length = 500, nullable = true)
    private String lastName;
    
    @Column(name = "C_USER_EMAIL_ADDRESS", length = 500, nullable = false)
    private String emailId;
    
    /**
     * This column can hold either male or female as value
     * hence female is considered max no of char it can hold
     */
    @Column(name = "C_USER_GENDER", length = 6, nullable = false)
    private String sex;
    
    @Column(name = "C_USER_AGE", nullable = false)
    private int age;
    
    public UsersWithCustomTableInformations(){
    }
    
    public UsersWithCustomTableInformations(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsersWithCustomTableInformations other = (UsersWithCustomTableInformations) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
