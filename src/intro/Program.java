package intro;

public class Program {

    public static void main(String[] args) {

        int decimal = asDecimal("11001101");
        String str = asString(205);

        System.out.println(decimal); // 205
        System.out.println(str); //   "101"
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
