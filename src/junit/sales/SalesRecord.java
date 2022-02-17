package junit.sales;

public class SalesRecord {

    private final String productId;
    public int productPrice;
    public int itemsSold;
    public int totalSum;

    public SalesRecord(String productId, int productPrice, int itemsSold) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.itemsSold = itemsSold;
        this.totalSum = itemsSold * productPrice;
    }


    public String getProductId() {
        return productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public int getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return "SalesRecord{" + "productId='" + productId + '\'' + ", productPrice=" + productPrice +
                ", itemsSold=" + itemsSold +
                '}';
    }
}
