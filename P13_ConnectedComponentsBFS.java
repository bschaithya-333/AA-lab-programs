// 9. Horspool String Matching Algorithm
public class P09_Horspool {
    public static void main(String[] args) {
        String text = "ABDACFEBACDDB", pattern = "CFE";
        int n = text.length(), m = pattern.length();
        int[] shift = new int[256];
        java.util.Arrays.fill(shift, m);
        for (int i = 0; i < m - 1; i++) shift[pattern.charAt(i)] = m - 1 - i;

        int i = m - 1;
        boolean found = false;
        while (i < n) {
            int k = 0;
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) k++;
            if (k == m) { System.out.println("Pattern found at index: " + (i - m + 1)); found = true; break; }
            i += shift[text.charAt(i)];
        }
        if (!found) System.out.println("Pattern not Found");
    }
}
