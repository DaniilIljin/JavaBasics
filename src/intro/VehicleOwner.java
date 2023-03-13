package intro;

import java.net.*;
import java.util.Scanner;


import java.io.*;
import java.math.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class VehicleOwner {
    private int vehicles;
    public VehicleOwner(int vehicles){
        this.vehicles = vehicles;
    }

    public int getVehicles() {
        return vehicles;
    }
    public static void main(String[] args) {
        List<VehicleOwner> owners = new ArrayList<>(Arrays.asList(
                new VehicleOwner(2),
                new VehicleOwner(7),
                new VehicleOwner(12),
                new VehicleOwner(24),
                new VehicleOwner(37),
                new VehicleOwner(40)
        ));

        System.out.println(VehicleOwner.sortOwnersByNumberOfOwnedVehicles(owners).stream().map(each -> each.vehicles).toList());
    }

    public static List<VehicleOwner> sortOwnersByNumberOfOwnedVehicles (List<VehicleOwner> vehicleOwners){
        return vehicleOwners.stream().sorted(Collections.reverseOrder(Comparator.comparing(each -> each.vehicles))).toList();
    }
}





//
//import fp.Map;
//import oo.hide.Point;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.function.Function;


//public class Program {
//
//    public static void main(String[] args) {
//        LocalDate d = LocalDate.parse("2022-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
//
//        Function<Integer, String> a;
//
//        a = (b) -> "Hello";
//
//
//        System.out.println(5/4);
//    }
//
//    public static String asString(int num) {
//        String str = "";
//        while (num > 0){
//            String number = Integer.toString(num % 2);
//            str = number + str;
//           num = num / 2;
//        }
//        return str;
//    }
//
//    public static int asDecimal(String str) {
//        int answer = 0;
//        for (int i = str.length();i > 0; i--) {
//            if (str.charAt(i - 1) == '1') {
//                int c = str.length() - i;
//                answer += pow(2, c);
//            }
//        }
//        return answer;
//    }
//
//    private static int pow(int arg, int power) {
//        // Java has Math.pow() but this time write your own impleme ntation.
//        if (power == 0){
//            return 1;
//        }
//        int answ = 1;
//        for (int i = 1; i < power + 1; i++) {
//            answ = answ * arg;
//        }
//        return answ;
//    }
//
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
