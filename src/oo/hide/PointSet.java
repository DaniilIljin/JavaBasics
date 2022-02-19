package oo.hide;


public class PointSet {
    private Point[] array;

    public PointSet(int capacity) {
        this.array = new Point[capacity];
    }

    public PointSet() {
        this(10);
    }


    public void add(Point point) {
        if (!(contains(point))){
             if (!(contains(null))){
                 Point[] newArray = new Point[array.length * 2];
                 for (int i = 0; i < array.length; i++) {
                     newArray[i] = array[i];
                 }
                 newArray[array.length] = point;
                 array = newArray;
             } else {
                 int pointCounter = 0;
                 for (Point point1 : array) {
                     if (point1 != null){
                         pointCounter++;
                     }
                 }
                 array[pointCounter] = point;
             }
        }
    }


    public int size() {
        int counter = 0;
        for (Point point : array) {
            if (point != null) {
                counter++;
            }
        }
        return counter;
    }

    public boolean contains(Point point) {
        for (Point point1 : array) {
            if (point1 != null) {
                if (point1.equals(point)){
                    return true;
                }
            } else if (point == null){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String newOne = "";
        for (Point point : array) {
            if (point != null){
                if(!(point.equals(array[size() - 1]))){
                    newOne += point.toString() + ", ";
                } else {
                    newOne += point.toString();
                }
            }
        }
        return newOne;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof PointSet other){
            if (this.size() == other.size()){
                for (Point point : array) {
                    if(point != null){
                        int counter = 0;
                        for (Point point1 : other.array) {
                            if ((point1 != null) && !(point.equals(point1))){
                                counter++;
                            }
                        }
                        if (counter == other.size()){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public PointSet subtract(PointSet other) {
        PointSet newOne = new PointSet();
        for (Point point : array) {
            if (point != null) {
                int counter = 0;
                for (Point point1 : other.array) {
                    if ((point1 != null) && !(point.equals(point1))){
                        counter++;
                    }
                }
                if (counter == other.size()){
                    newOne.add(point);
                }
            }
        }
        return newOne;
    }

    public PointSet intersect(PointSet other) {
        PointSet newOne = new PointSet();
        for (Point point : array) {
            if (point != null) {
                int counter = 0;
                for (Point point1 : other.array) {
                    if ((point1 != null) && !(point.equals(point1))){
                        counter++;
                    }
                }
                if (counter < other.size()){
                    newOne.add(point);
                }
            }
        }
        return newOne;
    }
}
