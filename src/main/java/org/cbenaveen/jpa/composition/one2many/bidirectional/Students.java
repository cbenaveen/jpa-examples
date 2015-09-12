package org.cbenaveen.jpa.composition.one2many.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Students {

    @Id
    @Column(name = "S_ROLL_NUMBER")
    private Long rollNumber;
    @Column(name = "S_NAME")
    private String name;
    @Column(name = "S_EMAIL_ID")
    private String emailId;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_CODE", nullable = false)
    private Department department;

    public Long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Long rollNumber) {
        this.rollNumber = rollNumber;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
