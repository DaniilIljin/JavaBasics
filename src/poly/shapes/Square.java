package poly.shapes;

public class Square implements Shapes{
    private int side;

    public Square(int side) {
        this.side = side;
    }


    public int getSide() {
        return side;
    }

    @Override
    public Double getArea() {
        return Math.pow(side, 2);
    }
}
