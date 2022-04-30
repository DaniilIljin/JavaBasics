package oo.hide;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point another)){
            return false;
        }
        return Objects.equals(x, another.x) && Objects.equals(y, another.y);
    }
}
