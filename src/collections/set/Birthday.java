package collections.set;

import org.junit.Test;

import java.util.*;


public class Birthday {

    @Test
    public void runCode() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(findCollision());
        }
        int sum = 0;
        for (Integer integer : list) {
          sum += integer;
        }
        System.out.println(sum / list.size());
    }

    private int findCollision() {
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 365; i++) {
            int randomDayOfYear = r.nextInt(365);
            if (set.contains(randomDayOfYear)){
                return i;
            } else {
                set.add(randomDayOfYear);
            }
        }
        throw new IllegalStateException("error");
    }
}
