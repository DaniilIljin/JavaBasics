package types;

public class Overload {

    public static void main(String[] args) {
        long x = 23;
        long y = 32;
        int a = 23;
        int b = 32;
        String s = "23";
        String o = "32";
        System.out.println(add(x, y));
        System.out.println(add(a, b));
        System.out.println(add(s, o));
    }

    public static long add(long x, long y) {
        System.out.println("Adding longs");
        return x + y;
    }

    public static int add(int x, int y) {
        System.out.println("Adding integers");
        return x + y;
    }

    public static long add(String x, String y) {
        System.out.println("Adding numbers from strings");
        return Long.parseLong(x) + Long.parseLong(y);
    }

}
