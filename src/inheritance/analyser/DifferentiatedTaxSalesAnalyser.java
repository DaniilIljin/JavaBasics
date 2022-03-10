package inheritance.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractTaxSalesAnalyser{

    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double getTotalSales() {
        double s = 0d;
        for (SalesRecord record : records) {
            if (record.hasReducedRate()) {
                s += record.getProductPrice() * record.getItemsSold() / 1.1;
            } else {
                s += record.getProductPrice() * record.getItemsSold() / 1.2;
            }
        }
        return s;
    }
    @Override
    protected Double getTotalSalesByProductId(String id) {
        double s = 0d;
        for (SalesRecord record : records) {
            if (record.getProductId().equals(id)) {
                if (record.hasReducedRate()) {
                    s += record.getProductPrice() * record.getItemsSold() / 1.1;
                } else {
                    s += record.getProductPrice() * record.getItemsSold() / 1.2;
                }
            }
        }
        return s;
    }
}
