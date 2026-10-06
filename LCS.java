import java.util.Scanner;

public class LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        // Find LCS length
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct LCS
        StringBuilder result = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } 
            else {
                j--;
            }
        }

        result.reverse();

        System.out.println("LCS Length: " + dp[m][n]);
        System.out.println("LCS: " + result);

        sc.close();
    }
}