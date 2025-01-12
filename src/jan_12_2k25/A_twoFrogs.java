package jan_12_2k25;

import java.util.Scanner;

public class A_twoFrogs {
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0){

            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();


            if ((a - 1) == b || (a + 1) == b) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }


        }


    }
}
