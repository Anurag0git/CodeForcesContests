package jan_12_2k25;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases
        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            String s = scanner.next(); // Path string

            // Read the altitude grid
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            // Initialize sums for rows and columns
            long[] rowSum = new long[n];
            long[] colSum = new long[m];
            Set<String> pathCells = new HashSet<>();

            // Determine path cells and calculate sums for non-path cells
            int x = 0, y = 0; // Starting position (1, 1) => (0, 0) in 0-indexed
            for (char step : s.toCharArray()) {
                pathCells.add(x + "," + y); // Mark path cell
                if (step == 'D') {
                    x++;
                } else if (step == 'R') {
                    y++;
                }
            }
            pathCells.add(x + "," + y); // Add the last cell

            // Calculate sums and identify path cells
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!pathCells.contains(i + "," + j)) {
                        rowSum[i] += a[i][j];
                        colSum[j] += a[i][j];
                    }
                }
            }

            // Find the maximum sum to restore
            long targetSum = 0;
            for (long sum : rowSum) {
                targetSum = Math.max(targetSum, sum);
            }
            for (long sum : colSum) {
                targetSum = Math.max(targetSum, sum);
            }

            // Fill path values based on target sum
            x = 0;
            y = 0;
            for (char step : s.toCharArray()) {
                if (step == 'D') {
                    // Calculate value for down cell
                    a[x][y] = targetSum - rowSum[x];
                    rowSum[x] += a[x][y];
                    colSum[y] += a[x][y];
                    x++;
                } else if (step == 'R') {
                    // Calculate value for right cell
                    a[x][y] = targetSum - colSum[y];
                    rowSum[x] += a[x][y];
                    colSum[y] += a[x][y];
                    y++;
                }
            }
            // Fill the last cell on the path
            a[x][y] = targetSum - rowSum[x];

            // Output the restored grid
            for (long[] row : a) {
                for (long val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
