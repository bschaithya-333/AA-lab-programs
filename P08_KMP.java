// 2. Multiplication of Long Integers using Divide and Conquer (Karatsuba)
public class P02_Karatsuba {
    static long multiply(long x, long y) {
        if (x < 10 || y < 10) return x * y;
        int m = Math.max(Long.toString(x).length(), Long.toString(y).length()) / 2;
        long power = (long) Math.pow(10, m);
        long a = x / power, b = x % power;
        long c = y / power, d = y % power;
        long ac = multiply(a, c);
        long bd = multiply(b, d);
        long adbc = multiply(a + b, c + d) - ac - bd;
        return ac * power * power + adbc * power + bd;
    }

    public static void main(String[] args) {
        long x = 1234, y = 5678;
        System.out.println("Product = " + multiply(x, y));
    }
}
