package org.cbenaveen.jpa.composition.one2one.bidirectonal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Use below sql commands to create the tables in PostgreSQL
 */
@Entity
@Table(name = "ONE2ONE_BIDIRECTIONAL_MAPPING_COURSE")
public class Course {

    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
    @TableGenerator(name = "ID_GENERATOR",
                                pkColumnName = "PK_ID", 
                                pkColumnValue = "COURSE_ID", 
                                valueColumnName = "PK_VALUE",
                                table="ONE2ONE_BIDIRECTIONAL_MAPPING_ID_GENERATOR",
                                initialValue = 1
    )
    private long courseId;
    
    @Column(name = "COURSE_NAME", nullable = false)
    private String courseName;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;
    
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="COURSE_INSTRUCTOR_ID")
    @PrimaryKeyJoinColumn
    private Instructor instructor;
    
    public long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
