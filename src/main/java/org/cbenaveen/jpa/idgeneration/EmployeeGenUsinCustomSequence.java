package org.cbenaveen.jpa.idgeneration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EmployeeGenUsinCustomSequence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="empCustomSequence")
    @SequenceGenerator(name="empCustomSequence", initialValue=5, allocationSize=5, sequenceName="EMPLOYEE_CUSTOM_SEQUENCE")
    private long id;
}
