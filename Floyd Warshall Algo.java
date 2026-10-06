import java.util.*;

class FloydWarshall {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] dist = new int[n][n];

        System.out.println("Enter the distance matrix:");
        System.out.println("Enter 999 for INF:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != 999 && dist[k][j] != 999 &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Display shortest distance matrix
        System.out.println("\nShortest Distance Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dist[i][j] == 999)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}