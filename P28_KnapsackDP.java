// 32. Simplex Optimization Algorithm (brute-force LP over integer grid)
public class P32_Simplex {
    public static void main(String[] args) {
        int c1 = 3, c2 = 2;
        int[][] a = {{1, 1}, {1, 3}};
        int[] b = {4, 6};

        int maxZ = Integer.MIN_VALUE, bestX = 0, bestY = 0;
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                boolean ok = true;
                for (int i = 0; i < a.length; i++)
                    if (a[i][0] * x + a[i][1] * y > b[i]) { ok = false; break; }
                if (ok) {
                    int z = c1 * x + c2 * y;
                    if (z > maxZ) { maxZ = z; bestX = x; bestY = y; }
                }
            }
        }
        System.out.println("Optimal Solution:");
        System.out.println("x = " + bestX);
        System.out.println("y = " + bestY);
        System.out.println("Maximum z = " + maxZ);
    }
}
