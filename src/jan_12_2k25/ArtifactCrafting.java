package jan_12_2k25;

import java.util.Scanner;

public class ArtifactCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases
        StringBuilder results = new StringBuilder();

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of types of materials
            long[] a = new long[n];
            long[] b = new long[n];

            // Read amounts of each material
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            // Read required amounts of each material
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextLong();
            }

            // Calculate total available and total required resources
            long totalAvailable = 0;
            long totalRequired = 0;

            for (int i = 0; i < n; i++) {
                totalAvailable += a[i];
                totalRequired += b[i];
            }

            // Check if total resources available are sufficient
            if (totalAvailable < totalRequired) {
                results.append("NO\n");
                continue;
            }

            // Check individual material requirements
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) { // If we need more of material i than we have
                    long needed = b[i] - a[i];
                    // Check if we can meet the requirement
                    if ((totalAvailable - a[i]) < needed) {
                        possible = false;
                        break;
                    }
                }
            }

            results.append(possible ? "YES\n" : "NO\n");
        }

        System.out.print(results.toString());
        scanner.close();
    }
}
