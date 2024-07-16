import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long totalPrice = sc.nextLong();
        int saleCounts = sc.nextInt();

        for (int i = 0; i < saleCounts; i++) {
            int price = sc.nextInt();
            int count = sc.nextInt();
            totalPrice -= (long) price * count;
        }

        if (totalPrice == 0) {
            System.out.print("Yes");
        } else {
            System.out.println("No");
        }
    }
}