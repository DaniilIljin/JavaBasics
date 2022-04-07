package poly.shapes;

public class Circle implements Shapes{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }


    @Override
    public Double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
