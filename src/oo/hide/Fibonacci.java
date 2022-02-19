package oo.hide;

public class Fibonacci {
    private int firstNum = 0;
    private int secondOne = 1;

    public int nextValue() {
        int result = firstNum;
        int neededValue = firstNum + secondOne;
        firstNum = secondOne;
        secondOne = neededValue;

        return result;
    }

}
