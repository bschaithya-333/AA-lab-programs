// 17. Bubble Sort
public class P17_BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 2, 1, 3, 4};
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - i - 1; j++)
                if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t; }

        System.out.println("Sorted Array:");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
