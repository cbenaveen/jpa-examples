package org.cbenaveen.jpa.composition.one2one.unidirectonal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "ONE2ONE_UNIDIRECTONAL_MAPPING_INSTRUCTOR")
public class Instructor {
    
    @Id
    @Column(name = "INSTRUCTOR_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
    @TableGenerator(name = "ID_GENERATOR",
                                pkColumnName = "PK_ID", 
                                pkColumnValue = "INSTRUCTOR_ID", 
                                valueColumnName = "PK_VALUE",
                                table="ONE2ONE_UNIDIRECTONAL_MAPPING_ID_GENERATOR",
                                initialValue = 1
    )
    private long instructorId;
    
    @Column(name = "INSTRUCTOR_NAME")
    private String name;
    
    @Column(name = "INSTRUCTOR_AGE")    
    private int age;

    public long getInstructorId() {
        return instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
