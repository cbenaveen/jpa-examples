package org.cbenaveen.jpa.composition.one2many.unidirectional;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ONE2MANY_UNIDIRECTIONAL_MAPPING_STOCK_DAILY_RECORD")
public class StockDailyRecord {

    private long recordId;
    private Set<Stock> stocks;
    private Date recordDate;

    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.DATE)
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "ONE2MANY_UNIDIRECTIONAL_MAPPING_STOCK_AND_STOCK_DAILY_RECORD",
            joinColumns = @JoinColumn(name = "STOCK_DAILY_RECORD_ID", referencedColumnName = "STOCK_RECORD_ID"),
            inverseJoinColumns = @JoinColumn(name = "STOCK_ID", referencedColumnName = "STOCK_ID")
    )
    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Id
    @Column(name = "STOCK_RECORD_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "STOCK_ID_GENERATOR")
    @TableGenerator(name = "STOCK_ID_GENERATOR",
                                pkColumnName = "PK_ID", 
                                pkColumnValue = "STOCK_RECORD_ID", 
                                valueColumnName = "PK_VALUE",
                                table="ONE2MANY_UNIDIRECTIONAL_MAPPING_STOCK_ID_GENERATOR",
                                initialValue = 1
    )
    public long getRecordId() {
        return recordId;
    }
    
    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }
}
