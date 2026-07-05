// 8. Knuth-Morris-Pratt (KMP) Pattern Matching Algorithm
public class P08_KMP {
    static int[] buildLPS(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0, i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) lps[i++] = ++len;
            else if (len != 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        return lps;
    }

    public static void main(String[] args) {
        String txt = "ABABDAAABABCA", pat = "ABABC";
        int[] lps = buildLPS(pat);
        int i = 0, j = 0;
        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) { i++; j++; }
            if (j == pat.length()) {
                System.out.println("Pattern found at index: " + (i - j));
                j = lps[j - 1];
            } else if (i < txt.length() && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) j = lps[j - 1]; else i++;
            }
        }
    }
}
