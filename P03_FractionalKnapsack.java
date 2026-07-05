// 7. Rabin-Karp String Matching Algorithm
public class P07_RabinKarp {
    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CCD";
        int n = text.length(), m = pattern.length();
        int patHash = pattern.hashCode();
        for (int i = 0; i <= n - m; i++) {
            String sub = text.substring(i, i + m);
            if (sub.hashCode() == patHash && sub.equals(pattern))
                System.out.println("Pattern Found at index: " + i);
        }
    }
}
