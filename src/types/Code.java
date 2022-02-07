package types;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Code {

    public static void main(String[] args) {

        int[] numbers = {1, 3, -2, 9};

        System.out.println(sum(numbers)); //  11

        System.out.println(average(new int[] {1, 2})); // 1.5

        System.out.println(minimumElement(new int[] {1, 2}));

        System.out.println(minimumElement(new int[] {}));

        System.out.println(asString(new int[] { 1, 3, -2, 9 }));  //tagastab "1, 3, -2, 9"

        System.out.println(mode("bbbbaaaaacccccc"));

        System.out.println(squareDigits("a9b2"));
    }

    public static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double average(int[] numbers) {
        return Double.valueOf(sum(numbers)) / numbers.length;
    }

    public static Integer minimumElement(int[] integers) {
        if (integers.length == 0){
            return null;
        }
        else {
            if (integers.length == 1){
                return integers[0];
            }
            else {
                int min = integers[0];
                for (int i = 1; i < integers.length; i++) {
                    if (integers[i] < min){
                        min = integers[i];
                    }
                }
                return min;
            }

        }
    }

    public static String asString(int[] elements) {
        String str = "";
        if (elements == null){
         return str;
        }
        else {
            for (int element : elements) {
                str += String.valueOf(element);
                if (element == elements[elements.length - 1]){
                    break;
                } else {
                    str += ", ";
                }
            }
        }
        return str;
    }

    public static Character mode(String input) {
        if (Objects.equals(input, "")){
        return null;
        }
        Character mostFriquent = null;
        int frequency = 0;
        for (int i = 0; i < input.length(); i++) {
             char ch = input.charAt(i);
             int counter = 0;
            for (int j = 0; j < input.length(); j++) {
                if (ch == input.charAt(j)){
                    counter ++;
                }
            }
            if (counter > frequency){
                mostFriquent = ch;
                frequency = counter;
            }
        }
        return mostFriquent;
    }

    public static String squareDigits(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                str += Math.round(Math.pow(Integer.parseInt(Character.toString(s.charAt(i))), 2));
            }
            else {
                str += Character.toString(s.charAt(i));
            }
        }
        return str;
    }

    public static int isolatedSquareCount() {
        boolean[][] matrix = getSampleMatrix();

        printMatrix(matrix);

        int isolatedCount = 0;

        // count isolates squares here

        return isolatedCount;
    }

    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean[][] getSampleMatrix() {
        boolean[][] matrix = new boolean[10][10];

        Random r = new Random(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = r.nextInt(5) < 2;
            }
        }

        return matrix;
    }
}
