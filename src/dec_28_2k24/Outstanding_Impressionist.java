package dec_28_2k24;

import java.util.*;

public class Outstanding_Impressionist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Number of impressions
            int[][] ranges = new int[n][2];

            // Read the ranges
            for (int j = 0; j < n; j++) {
                ranges[j][0] = scanner.nextInt(); // li
                ranges[j][1] = scanner.nextInt(); // ri
            }

            // Count occurrences of each possible w
            int[] count = new int[2 * n + 2]; // to accommodate 1 to 2n
            for (int j = 0; j < n; j++) {
                count[ranges[j][0]]++; // Start of range
                count[ranges[j][1] + 1]--; // End of range
            }

            // Create the actual coverage array using prefix sum
            int[] coverage = new int[2 * n + 1];
            int current = 0;
            for (int j = 1; j <= 2 * n; j++) {
                current += count[j];
                coverage[j] = current;
            }

            // Check for each impression if it is unique
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                boolean unique = false;
                for (int v = ranges[j][0]; v <= ranges[j][1]; v++) {
                    if (coverage[v] == 1) {
                        unique = true;
                        break;
                    }
                }
                result.append(unique ? '1' : '0');
            }

            resultBuilder.append(result).append("\n");
        }

        // Print all results for each test case
        System.out.print(resultBuilder);
        scanner.close();
    }
}
