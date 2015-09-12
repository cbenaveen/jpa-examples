package org.cbenaveen.jpa.examples.composition.one2many.unidirectional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.composition.one2many.unidirectional.Stock;
import org.cbenaveen.jpa.composition.one2many.unidirectional.StockDailyRecord;
import org.junit.Test;

public class One2ManyUnidirectonalMappingJunitTest extends AbstractJunitTest {
    public One2ManyUnidirectonalMappingJunitTest() {
        super("examples.composition.one2many.unidirectonal");
    }

    @Test
    public void test() {
        Stock infosys = createStock("INFY", 1084.10, 1110.70, 170300);
        Stock ongc = createStock("ONGC", 230.75, 243.55, 630813);
        Stock bpcl = createStock("BPCL", 882.15, 860.90, 131817);
        Stock neyvelilig = createStock("NEYVELILIG", 73.95, 74.00, 18498);

        Set<Stock> stockes = new HashSet<Stock>();
        stockes.add(infosys);
        stockes.add(ongc);
        stockes.add(bpcl);
        stockes.add(neyvelilig);

        StockDailyRecord sdr = new StockDailyRecord();
        sdr.setRecordDate(new Date());
        sdr.setStocks(stockes);

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(sdr);
        tx.commit();
        
        entityManager.clear();
        StockDailyRecord fromDb = entityManager.find(StockDailyRecord.class, 1l);
        System.out.println("Stock Record Date: " + fromDb.getRecordDate());
        System.out.println("List of Stock information");
        for(Stock stock: fromDb.getStocks()){
            System.out.println("===> Stock Information [Stock Symbol Name: " + stock.getSymbol() + ", Opening Price: " + stock.getOpeningPrice() 
                    + ", Closing price: " + stock.getClosingPrice() + ", Traded volume: " + stock.getVolume() + "]");
        }
    }

    /**
     * Helper method create {@link Stock} object
     * 
     * @param name
     *            stock symbol name
     * @param oPrice
     *            opening price
     * @param cPrice
     *            closing price
     * @param volume
     *            traded volume
     * @return {@link Stock}
     */
    private Stock createStock(String name, double oPrice, double cPrice,
            int volume) {
        Stock stock = new Stock();
        stock.setSymbol(name);
        stock.setOpeningPrice(oPrice);
        stock.setClosingPrice(cPrice);
        stock.setVolume(volume);

        return stock;
    }
}
