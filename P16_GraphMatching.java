// 18. Selection Sort
public class P18_SelectionSort {
    public static void main(String[] args) {
        int[] a = {4, 6, 8, 9, 2, 1};
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
            int t = a[i]; a[i] = a[min]; a[min] = t;
        }
        System.out.println("Sorted Array:");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
