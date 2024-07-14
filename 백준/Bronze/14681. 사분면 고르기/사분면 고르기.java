import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int quadrant;
        
        if(x<0){
            
            if(y<0){
                quadrant = 3;
            }
            else{
                quadrant = 2;
            }
            
        }else{
            
            if(y<0){
                quadrant = 4;
            }
            else{
                quadrant = 1;
            }
            
        }

        System.out.println(quadrant);
    }
}