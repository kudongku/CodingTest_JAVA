import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        int bDividedHundred = b/100;
        int bDividedTen = (b-bDividedHundred*100)/10;
        int bDividedOne = b-bDividedHundred*100-bDividedTen*10;
        System.out.println(a*bDividedOne);
        System.out.println(a*bDividedTen);
        System.out.println(a*bDividedHundred);
        System.out.println(a*b);
    }
}