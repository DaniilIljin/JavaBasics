package junit.sales;


public class TopSalesFinder {
    public SalesRecord[] allRecords = new SalesRecord[0];

//    public static void main(String[] args) {
//        System.out.println(new SalesRecord("U", 1, 1).getProductId());
//        TopSalesFinder tsf = new TopSalesFinder();
//        tsf.registerSale(new SalesRecord("p1", 20, 1));
//        tsf.registerSale(new SalesRecord("p2", 20, 1));
//        tsf.registerSale(new SalesRecord("p2", 20, 1));
//        tsf.registerSale(new SalesRecord("p1", 10, 1));
//        tsf.registerSale(new SalesRecord("p3", 50, 1));
//        System.out.println(Arrays.toString(tsf.findItemsSoldOver(39)));
//
//    }

    public void registerSale(SalesRecord record) {
        boolean checker = true;
        if (this.allRecords.length == 0){
            this.allRecords = expandingList(this.allRecords, record);
        } else {
            for (SalesRecord storedRecord : this.allRecords) {
            if (storedRecord.getProductId().equals(record.getProductId())) {
                storedRecord.totalSum += record.totalSum;
                checker = false;
            }
        }
            if(checker){
                this.allRecords = expandingList(this.allRecords, record);
            }
        }
        // store sales record for later analyses by findItemsSoldOver()
    }

    public String[] findItemsSoldOver(int amount) {
        int counter = 0;
        for (SalesRecord record : this.allRecords) {
            if (amount < record.totalSum){
                counter++;
            }
        }
        String[] neededArray = new String[counter];
        int neededNum;
        for (SalesRecord record : this.allRecords) {
            if (amount < record.totalSum){
                neededNum = neededArray.length - counter;
                neededArray[neededNum] = record.getProductId();
                counter--;
            }
        }
        // find ids of records that sold over specified amount.
        return neededArray;
    }

    public SalesRecord[] expandingList(SalesRecord[] array, SalesRecord currentRecord){
        SalesRecord[] finalList = new SalesRecord[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            finalList[i] = array[i];
        }
        finalList[this.allRecords.length] = currentRecord;
        return finalList;
    }

}
