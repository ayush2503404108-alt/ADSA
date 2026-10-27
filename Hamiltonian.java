import java.util.Scanner;

class Main {
    static int n, path[];
    static int[][] g;

    static boolean solve(int pos) {
        if (pos == n)
            return g[path[pos - 1]][path[0]] == 1;

        for (int v = 1; v < n; v++) {
            if (g[path[pos - 1]][v] == 1) {
                boolean ok = true;

                for (int i = 0; i < pos; i++)
                    if (path[i] == v) ok = false;

                if (ok) {
                    path[pos] = v;
                    if (solve(pos + 1)) return true;
                    path[pos] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        g = new int[n][n];
        path = new int[n];
        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++) path[i] = -1;
        path[0] = 0;

        if (solve(1)) {
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");
            System.out.println(path[0]);
        } else {
            System.out.println("No Hamiltonian Cycle");
        }
    }
}