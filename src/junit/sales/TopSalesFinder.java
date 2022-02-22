package junit.sales;



public class TopSalesFinder {
    public SalesRecord[] allRecords = new SalesRecord[0];
    public String[] repeated1 = new String[0];
    public String[] repeated2 = new String[0];


    public static void main(String[] args) {

//        System.out.println(new SalesRecord("U", 1, 1).getProductId());
//        TopSalesFinder tsf = new TopSalesFinder();
//        tsf.registerSale(new SalesRecord("p1", 20, 1));
//        tsf.registerSale(new SalesRecord("p2", 20, 1));
//        tsf.registerSale(new SalesRecord("p2", 20, 1));
//        tsf.registerSale(new SalesRecord("p1", 10, 1));
//        tsf.registerSale(new SalesRecord("p3", 50, 1));
//        System.out.println(Arrays.toString(tsf.findItemsSoldOver(39)));

    }

    public void registerSale(SalesRecord record) {
        this.allRecords = expandingList(this.allRecords, record);
        // store sales record for later analyses by findItemsSoldOver()
    }

    public String[] findItemsSoldOver(int amount) {
        int counter = 0;
        for (SalesRecord record : this.allRecords) {
            if (amount < findNeededProduct(record.getProductId()) && (repeats1(record.getProductId()))){
                counter++;
                expandingList1(record.getProductId());
            }
        }
        String[] neededArray = new String[counter];
        int neededNum;
        for (SalesRecord record : this.allRecords) {
            if (amount < findNeededProduct(record.getProductId()) && (repeats2(record.getProductId()))){
                expandingList2(record.getProductId());
                neededNum = neededArray.length - counter;
                neededArray[neededNum] = record.getProductId();
                counter--;
            }
        }
        // find ids of records that sold over specified amount.
        this.repeated1 = new String[0];
        this.repeated2 = new String[0];
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

    public int findNeededProduct(String id){
        int totalSum = 0;
        for (SalesRecord record : this.allRecords) {
            if (record.getProductId().equals(id)){
                totalSum += record.getProductPrice() * record.getItemsSold();
            }
        }
        return totalSum;
    }
    public boolean repeats1(String s){
        boolean answer = true;
        for (String s1 : this.repeated1) {
            if(s.equals(s1)){
                answer = false;
            }
        }
        return answer;
    }
    public boolean repeats2(String s){
        boolean answer = true;
        for (String s1 : this.repeated2) {
            if(s.equals(s1)){
                answer = false;
            }
        }
        return answer;
    }
    public void expandingList1(String currentRecord){
        String[] finalList = new String[ this.repeated1.length + 1];
        for (int i = 0; i < this.repeated1.length; i++) {
            finalList[i] = this.repeated1[i];
        }
        finalList[this.repeated1.length] = currentRecord;
        this.repeated1 = finalList;
    }
    public void expandingList2(String currentRecord){
        String[] finalList = new String[ this.repeated2.length + 1];
        for (int i = 0; i < this.repeated2.length; i++) {
            finalList[i] = this.repeated2[i];
        }
        finalList[this.repeated2.length] = currentRecord;
        this.repeated2 = finalList;
    }

}
