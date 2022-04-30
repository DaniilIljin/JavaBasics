package inheritance.pager;

import java.util.List;

public class FilteringPager {

    @SuppressWarnings("PMD.UnusedPrivateField")
    private final SimplePager dataSource;
    @SuppressWarnings("PMD.UnusedPrivateField")
    private final int pageSize;

    private Integer pageNumber = 0;

    public FilteringPager(SimplePager dataSource, int pageSize) {
        this.dataSource = dataSource;
        this.pageSize = pageSize;
    }

    public List<Integer> getNextPage() {
//        if(dataSource.getPage(pageNumber).size() == pageSize){
//            pageNumber++;
//            return dataSource.getPage(pageNumber);
//        } else {
//
//        }
        throw new RuntimeException();
    }

    public List<Integer> getCurrentPage() {
        throw new RuntimeException("not implemented yet");
    }

    public List<Integer> getPreviousPage() {
        throw new RuntimeException("not implemented yet");
    }

}
