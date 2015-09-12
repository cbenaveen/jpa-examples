package org.cbenaveen.jpa.composition.one2many.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "ONE2MANY_UNIDIRECTIONAL_MAPPING_STOCK")
public class Stock {

    private long stockId;
    private String symbol;
    private double openingPrice;
    private double closingPrice;
    private long volume;
    
    @Column(name = "STOCK_SYMBOL")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Column(name = "STOCK_OPENING_PRICE")
    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    @Column(name = "STOCK_CLOSING_PRICE")
    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    @Column(name = "STOCK_VOLUME_TRADED")
    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Id
    @Column(name = "STOCK_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "STOCK_ID_GENERATOR")
    @TableGenerator(name = "STOCK_ID_GENERATOR",
                                pkColumnName = "PK_ID", 
                                pkColumnValue = "STOCK_ID", 
                                valueColumnName = "PK_VALUE",
                                table="ONE2MANY_UNIDIRECTIONAL_MAPPING_STOCK_ID_GENERATOR",
                                initialValue = 1
    )
    public long getStockId() {
        return stockId;
    }
    
    public void setStockId(long stockId) {
        this.stockId = stockId;
    }
}
