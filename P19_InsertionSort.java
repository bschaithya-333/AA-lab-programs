// 31. Basic to Modular Representation conversion
public class P31_BasicToModular {
    public static void main(String[] args) {
        int x = 23;
        int[] m = {3, 5, 7};
        StringBuilder sb = new StringBuilder("Modular Representation: ");
        for (int mod : m) sb.append(x % mod).append(" ");
        System.out.println(sb.toString());
    }
}
