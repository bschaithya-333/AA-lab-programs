// 30. Chinese Remainder Theorem
public class P30_CRT {
    static int modInverse(int a, int m) {
        a %= m;
        for (int x = 1; x < m; x++) if ((a * x) % m == 1) return x;
        return 1;
    }

    static int findX(int[] num, int[] rem) {
        int prod = 1;
        for (int v : num) prod *= v;
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int pp = prod / num[i];
            result += rem[i] * modInverse(pp, num[i]) * pp;
        }
        return result % prod;
    }

    public static void main(String[] args) {
        int[] num = {3, 5, 7};
        int[] rem = {2, 3, 2};
        System.out.println("x = " + findX(num, rem));
    }
}
