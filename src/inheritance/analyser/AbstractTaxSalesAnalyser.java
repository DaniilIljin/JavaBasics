package inheritance.analyser;

import java.util.List;

public sealed abstract class AbstractTaxSalesAnalyser
        permits FlatTaxSalesAnalyser, TaxFreeSalesAnalyser, DifferentiatedTaxSalesAnalyser{
    public List<SalesRecord> records;

    public AbstractTaxSalesAnalyser(List<SalesRecord> records){
        this.records = records;
    }
    protected abstract Double getTotalSales();

    protected abstract Double getTotalSalesByProductId(String id);

    protected String getIdOfMostPopularItem(){
        int counter = 0;
        int counter2 = 0;
        String id = null;
        String id2;
        for (SalesRecord record : records) {
            id2 = record.getProductId();
            for (SalesRecord salesRecord : records) {
                String u = salesRecord.getProductId();
                if (salesRecord.getProductId().equals(id2)){
                    counter2 += salesRecord.getItemsSold();
                }
            }
            if (counter2 > counter){
                counter = counter2;
                id = id2;
            }
            counter2 = 0;
        }
        return id;
    }

    protected String getIdOfItemWithLargestTotalSales(){
        int counter = 0;
        int counter2 = 0;
        String id = null;
        String id2;
        for (SalesRecord record : records) {
            id2 = record.getProductId();
            for (SalesRecord salesRecord : records) {
                String u = salesRecord.getProductId();
                if (salesRecord.getProductId().equals(id2)){
                    counter2 += salesRecord.getItemsSold() * salesRecord.getProductPrice();
                }
            }
            if (counter2 > counter){
                counter = counter2;
                id = id2;
            }
            counter2 = 0;
        }
        return id;
    }
}
