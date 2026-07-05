// 5. LU Decomposition Method (Doolittle's Algorithm)
public class P05_LUDecomposition {
    public static void main(String[] args) {
        double[][] A = {{2, -1, -2}, {-4, 6, 3}, {-4, -2, 8}};
        int n = A.length;
        double[][] L = new double[n][n], U = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                double sum = 0;
                for (int j = 0; j < i; j++) sum += L[i][j] * U[j][k];
                U[i][k] = A[i][k] - sum;
            }
            L[i][i] = 1.0;
            for (int k = i + 1; k < n; k++) {
                double sum = 0;
                for (int j = 0; j < i; j++) sum += L[k][j] * U[j][i];
                L[k][i] = (A[k][i] - sum) / U[i][i];
            }
        }
        System.out.println("L Matrix:");
        for (double[] row : L) { for (double v : row) System.out.printf("%.2f ", v); System.out.println(); }
        System.out.println("U Matrix:");
        for (double[] row : U) { for (double v : row) System.out.printf("%.2f ", v); System.out.println(); }
    }
}
