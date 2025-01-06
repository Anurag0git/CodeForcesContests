package dec_28_2k24;

import java.util.Arrays;
import java.util.Scanner;

public class Tender_Carpenter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
//int t = 1;

        while(t-- > 0){

            int n = sc.nextInt();

            int[] arr = new int[n];
//            int[] arr = {115, 9, 2, 28};

//            int n = arr.length;

            for(int i = 0; i< n; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            boolean possible = false;

            if(n==2){
                possible = true;
            }

            else {
                for (int i = 0; i < n - 2; i++) {
                    if (arr[i] + arr[i + 1] > arr[i + 2]) {
                        possible = true;
                        break;
                    }
                }
            }

            System.out.println(possible ? "Yes" : "No");

        }


    }

}
