package poly.shapes;

public class Rectangle implements Shapes{
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public Double getArea() {
        return Double.valueOf(height * width);
    }
}
