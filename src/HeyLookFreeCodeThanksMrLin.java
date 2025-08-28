import java.util.Scanner;
public class HeyLookFreeCodeThanksMrLin {


    public static void main(String [] args) {
        System.out.println("enter a number");
        int n = getNum();
        System.out.println("n is " + n);

        System.out.println("c to num: " + letter2Num("c"));

        System.out.println("0 to letter: " + num2Let(0));

    }

    static Scanner s = new Scanner(System.in);
    public static int getNum() {
        try {
            return Integer.parseInt(s.nextLine());
        }
        catch (Exception e) {
            System.out.println("not a number dummy");
            return -1;
        }
    }

    //a is 0
    public static int letter2Num(String s) {
        if (s.length() == 1)
            if(s.toUpperCase().charAt(0) >= 'A' && s.toUpperCase().charAt(0) <= 'Z')
                return s.toUpperCase().charAt(0) - 'A';
        System.out.println("not a letter dumdum");
        return -1;
    }

    //0 is A
    public static String num2Let(int n) {
        if (n <= 'Z'-'A')
            return "" + (char)('A' + n);
        return "no!";
    }

}
