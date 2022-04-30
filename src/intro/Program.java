package intro;

import oo.hide.Point;

public class Program {

    public static void main(String[] args) {

        Double u = Double.parseDouble("24.5");
    }

    public static String asString(int num) {
        String str = "";
        while (num > 0){
            String number = Integer.toString(num % 2);
            str = number + str;
           num = num / 2;
        }
        return str;
    }

    public static int asDecimal(String str) {
        int answer = 0;
        for (int i = str.length();i > 0; i--) {
            if (str.charAt(i - 1) == '1') {
                int c = str.length() - i;
                answer += pow(2, c);
            }
        }
        return answer;
    }

    private static int pow(int arg, int power) {
        // Java has Math.pow() but this time write your own impleme ntation.
        if (power == 0){
            return 1;
        }
        int answ = 1;
        for (int i = 1; i < power + 1; i++) {
            answ = answ * arg;
        }
        return answ;
    }

}
//package oo.hide;
//
//
//public class PointSet {
//    private Point[] array;
//
//    public PointSet(int capacity) {
//        this.array = new Point[capacity];
//    }
//
//    public PointSet() {
//        this(10);
//    }
//
//
//    public void add(Point point) {
//        if (!(contains(point))){
//            if (!(contains(null))){
//                Point[] newArray = new Point[array.length * 2];
//                for (int i = 0; i < array.length; i++) {
//                    newArray[i] = array[i];
//                }
//                newArray[array.length] = point;
//                array = newArray;
//            } else {
//                int pointCounter = 0;
//                for (Point point1 : array) {
//                    if (point1 != null){
//                        pointCounter++;
//                    }
//                }
//                array[pointCounter] = point;
//            }
//        }
//    }
//
//
//    public int size() {
//        int counter = 0;
//        for (Point point : array) {
//            if (point != null) {
//                counter++;
//            }
//        }
//        return counter;
//    }
//
//    public boolean contains(Point point) {
//        for (Point point1 : array) {
//            if (point1 != null) {
//                if (point1.equals(point)){
//                    return true;
//                }
//            } else if (point == null){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String toString(){
//        String newOne = "";
//        for (Point point : array) {
//            if (point != null){
//                if(!(point.equals(array[size() - 1]))){
//                    newOne += point.toString() + ", ";
//                } else {
//                    newOne += point.toString();
//                }
//            }
//        }
//        return newOne;
//    }
//
//    @Override
//    public boolean equals(Object obj){
//        if (obj instanceof oo.hide.PointSet other){
//            if (this.size() != other.size()){
//                return false;
//            }
//            for (Point point : array) {
//                if(point != null){
//                    int counter = 0;
//                    for (Point point1 : other.array) {
//                        if (point1 != null){
//                            if (!(point.equals(point1))){
//                                counter++;
//                            }
//                        }
//                    }
//                    if (counter == other.size()){
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//
//        return false;
//    }
//
//    public oo.hide.PointSet subtract(oo.hide.PointSet other) {
//        oo.hide.PointSet newOne = new oo.hide.PointSet();
//        for (Point point : array) {
//            if (point != null) {
//                int counter = 0;
//                for (Point point1 : other.array) {
//                    if((point1 != null)){
//                        if(!(point.equals(point1))){
//                            counter++;
//                        }
//                    }
//                }
//                if (counter == other.size()){
//                    newOne.add(point);
//                }
//            }
//        }
//        return newOne;
//    }
//
//    public oo.hide.PointSet intersect(oo.hide.PointSet other) {
//        oo.hide.PointSet newOne = new oo.hide.PointSet();
//        for (Point point : array) {
//            if (point != null) {
//                int counter = 0;
//                for (Point point1 : other.array) {
//                    if(point1 != null){
//                        if(!(point.equals(point1))){
//                            counter++;
//                        }
//                    }
//                }
//                if (counter < other.size()){
//                    newOne.add(point);
//                }
//            }
//        }
//        return newOne;
//    }
//}



//package oo.hide;
//
//
//public class PointSet {
//    private Point[] array;
//
//    public PointSet(int capacity) {
//        this.array = new Point[capacity];
//    }
//
//    public PointSet() {
//        this(10);
//    }
//
//
//    public void add(Point point) {
//        if (!(contains(point))){
//            if (!(contains(null))){
//                Point[] newArray = new Point[array.length * 2];
//                for (int i = 0; i < array.length; i++) {
//                    newArray[i] = array[i];
//                }
//                newArray[array.length] = point;
//                array = newArray;
//            } else {
//                int pointCounter = 0;
//                for (Point point1 : array) {
//                    if (point1 != null){
//                        pointCounter++;
//                    }
//                }
//                array[pointCounter] = point;
//            }
//        }
//    }
//
//
//    public int size() {
//        int counter = 0;
//        for (Point point : array) {
//            if (point != null) {
//                counter++;
//            }
//        }
//        return counter;
//    }
//
//    public boolean contains(Point point) {
//        for (Point point1 : array) {
//            if (point1 != null) {
//                if (point1.equals(point)){
//                    return true;
//                }
//            } else if (point == null){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String toString(){
//        String newOne = "";
//        for (Point point : array) {
//            if (point != null){
//                if(!(point.equals(array[size() - 1]))){
//                    newOne += point.toString() + ", ";
//                } else {
//                    newOne += point.toString();
//                }
//            }
//        }
//        return newOne;
//    }
//
//    @Override
//    public boolean equals(Object obj){
//        if (obj instanceof oo.hide.PointSet other){
//            if (this.size() == other.size()){
//                for (Point point : array) {
//                    if(point != null){
//                        int counter = 0;
//                        for (Point point1 : other.array) {
//                            if ((point1 != null) && !(point.equals(point1))){
//                                counter++;
//                            }
//                        }
//                        if (counter == other.size()){
//                            return false;
//                        }
//                    }
//                }
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public oo.hide.PointSet subtract(oo.hide.PointSet other) {
//        oo.hide.PointSet newOne = new oo.hide.PointSet();
//        for (Point point : array) {
//            if (point != null) {
//                int counter = 0;
//                for (Point point1 : other.array) {
//                    if ((point1 != null) && !(point.equals(point1))){
//                        counter++;
//                    }
//                }
//                if (counter == other.size()){
//                    newOne.add(point);
//                }
//            }
//        }
//        return newOne;
//    }
//
//    public oo.hide.PointSet intersect(oo.hide.PointSet other) {
//        oo.hide.PointSet newOne = new oo.hide.PointSet();
//        for (Point point : array) {
//            if (point != null) {
//                int counter = 0;
//                for (Point point1 : other.array) {
//                    if ((point1 != null) && !(point.equals(point1))){
//                        counter++;
//                    }
//                }
//                if (counter < other.size()){
//                    newOne.add(point);
//                }
//            }
//        }
//        return newOne;
//    }
//}
