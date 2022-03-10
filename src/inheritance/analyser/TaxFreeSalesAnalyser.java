package inheritance.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractTaxSalesAnalyser{

    public TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }
    @Override
    protected Double getTotalSales() {
        double s = 0d;
        for (SalesRecord record : records) {
            s += record.getProductPrice() * record.getItemsSold();
        }
        return s;
    }
    @Override
    protected Double getTotalSalesByProductId(String id) {
        double s = 0d;
        for (SalesRecord record : records) {
            if (record.getProductId().equals(id)) {
                s += record.getProductPrice() * record.getItemsSold();
            }
        }
        return s;
    }
}
