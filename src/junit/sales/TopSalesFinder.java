//package junit.sales;
//
//public class TopSalesFinder {
//    public static void main(String[] args) {
//
//    }
//
//    private SalesRecord[] records = new SalesRecord[0];
//
//    public void registerSale(SalesRecord record) {
//        for (SalesRecord salesRecord : records) {
//            if(salesRecord.getProductId().equals(record.getProductId())){
//                salesRecord.getItemsSold() += record.getItemsSold();
//            }else {
//                this.records = expandingList(this.records, record);
//            }
//        }
//        // store sales record for later analyses by findItemsSoldOver()
//
//    }
//
//    public String[] findItemsSoldOver(int amount) {
//        String[] neededIds = new String[0];
//        SalesRecord[] finalList = new SalesRecord[0];
//        for (SalesRecord record : this.records) {
//            if(record.getItemsSold() > amount){
//                finalList = expandingList(finalList, record);
//            }
//        }
//        for (SalesRecord salesRecord : finalList) {
//            neededIds = expandingList(neededIds, salesRecord.getProductId());
//        }
//        // find ids of records that sold over specified amount.
//
//        return neededIds;
//    }
//

//
//    public String[] expandingList(String[] array, String currentRecord){
//        String [] finalList = new String[array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            finalList[i] = array[i];
//        }
//        finalList[this.records.length] = currentRecord;
//        return finalList;
//    }
//}
//
//
package junit.sales;

import java.util.Arrays;

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
                storedRecord.totalSum += record.getTotalSum();
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
            if (amount < record.getTotalSum()){
                counter++;
            }
        }
        String[] neededArray = new String[counter];
        int neededNum;
        for (SalesRecord record : this.allRecords) {
            if (amount < record.getTotalSum()){
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
