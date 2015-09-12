package org.cbenaveen.jpa.idgeneration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATE_TABLE")
    @TableGenerator(name = "ID_GENERATE_TABLE", // A name to identify thisgenerator
        table = "ID_GENERATE_TABLE", // Name of the table name
        initialValue = 1, // initial value
        pkColumnName = "ID", // primary key column name
        pkColumnValue = "TEACHER_ID", // value collumn name
        valueColumnName = "ID_COLUMN")
    private long id;
}
