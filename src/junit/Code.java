package junit;

import java.util.Arrays;

public class Code {
    public static void main(String[] args) {
        System.out.println(mode("abbc"));
        System.out.println(longestStreak("aaabbceeee"));
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 2, 1, 3, 2})));
    }

    public static boolean isSpecial(int candidate) {
        return candidate % 11 <= 3;
    }

    public static int longestStreak(String inputString) {
        if (!"".equals(inputString)){
            char[] chars = inputString.toCharArray();
            int longestStreak = 0;
            for (int i = 0; i < chars.length; i++) {
                int currentStreak = 0;
                char currentChar = chars[i];
                for (int j = i; j < chars.length; j++) {
                    if(currentChar == chars[j]){
                        currentStreak++;
                    }else {
                        break;
                        }
                    }
                if (longestStreak < currentStreak) {
                    longestStreak = currentStreak;
                }
                currentStreak = 0;
                }
            return longestStreak;
                }
        return 0;
        }

    public static Character mode(String inputString) {
        if (inputString != null && !"".equals(inputString)){
            Character c = null;
            int frequency = 0;
            for (int i = 0; i < inputString.length(); i++) {
                if (getCharacterCount(inputString, inputString.charAt(i)) > frequency){
                    c = inputString.charAt(i);
                    frequency = getCharacterCount(inputString, inputString.charAt(i));
                }
            }
            return c;
        }
        return null;
    }


    public static int getCharacterCount(String allCharacters, char targetCharacter) {
        int counter = 0;
        for (int i = 0; i < allCharacters.length(); i++) {
            if (targetCharacter == allCharacters.charAt(i)){
                counter ++;
            }
        }
        return counter;
    }

    public static int[] removeDuplicates(int[] integers) {
        if (integers != null){
            int[] mainList = new int[0];
            for (int integer : integers) {
                if (checkNumber(mainList, integer)){
                    mainList = expandingList(mainList, integer);
                }
            }
            return mainList;
        }
        return null;
    }

    public static boolean checkNumber(int[] list, int num){
        for (int i : list) {
            if(i == num){
                return false;
            }
        }
        return true;
    }

    public static int[] expandingList(int[] list, int num){
        int[] finalList = new int[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            finalList[i] = list[i];
        }
        finalList[list.length] = num;
        return finalList;
    }

    public static int sumIgnoringDuplicates(int[] integers) {
        int [] neededArray = removeDuplicates(integers);
        int sum = 0;
        for (int i : neededArray) {
            sum += i;
        }
        return sum;
    }

}
