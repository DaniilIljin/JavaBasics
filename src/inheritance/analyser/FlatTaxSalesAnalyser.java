package inheritance.analyser;

import java.util.List;

public final class FlatTaxSalesAnalyser extends AbstractTaxSalesAnalyser {

    public FlatTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }
    @Override
    protected Double getTotalSales() {
        double sum = 0d;
        for (SalesRecord record : records) {
            sum += record.getItemsSold() * record.getProductPrice() / 1.2;
        }
        return sum;
    }
    @Override
    protected Double getTotalSalesByProductId(String id) {
        double s = 0d;
        for (SalesRecord record : records) {
            if (record.getProductId().equals(id)) {
                s += record.getProductPrice() * record.getItemsSold() / 1.2;
            }
        }
        return s;
    }
}
