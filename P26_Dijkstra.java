// 24. Strassen's Matrix Multiplication (2x2)
public class P24_Strassens {
    public static void main(String[] args) {
        int[][] A = {{8, 9}, {1, 3}};
        int[][] B = {{5, 6}, {7, 2}};
        int a = A[0][0], b = A[0][1], c = A[1][0], d = A[1][1];
        int e = B[0][0], f = B[0][1], g = B[1][0], h = B[1][1];

        int M1 = (a + d) * (e + h);
        int M2 = (c + d) * e;
        int M3 = a * (f - h);
        int M4 = d * (g - e);
        int M5 = (a + b) * h;
        int M6 = (c - a) * (e + f);
        int M7 = (b - d) * (g + h);

        int C11 = M1 + M4 - M5 + M7;
        int C12 = M3 + M5;
        int C21 = M2 + M4;
        int C22 = M1 - M2 + M3 + M6;

        System.out.println("Result Matrix: ");
        System.out.println(C11 + " " + C12);
        System.out.println(C21 + " " + C22);
    }
}
