// 4. Gaussian Elimination Method
public class P04_GaussianElimination {
    public static void main(String[] args) {
        double[][] a = {
            {2, 1, -1, 8},
            {-3, -1, 2, -11},
            {-2, 1, 2, -3}
        };
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double ratio = a[j][i] / a[i][i];
                for (int k = 0; k <= n; k++) a[j][k] -= ratio * a[i][k];
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = a[i][n];
            for (int j = i + 1; j < n; j++) x[i] -= a[i][j] * x[j];
            x[i] /= a[i][i];
        }
        System.out.println("Solution: ");
        for (int i = 0; i < n; i++) System.out.printf("x%d = %.1f%n", i + 1, x[i]);
    }
}
