import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArr = input.split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        int c = Integer.parseInt(inputArr[2]);
        int price;

        if(a==b && b==c){
            price = 10000 + a*1000;
        } else if (a==b) {
            price = 1000 + a*100;
        } else if (c==b) {
            price = 1000 + b*100;
        } else if (a==c) {
            price = 1000 + c*100;
        } else {
          int max = 0;

            for (String s : inputArr) {
                if (Integer.parseInt(s) > max) {
                    max = Integer.parseInt(s);
                }
            }

          price = max * 100;
        }

        System.out.println(price);
    }
}