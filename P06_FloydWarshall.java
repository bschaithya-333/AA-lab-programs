// 20. Merge Sort
public class P20_MergeSort {
    static void merge(int[] a, int l, int m, int r) {
        int[] L = java.util.Arrays.copyOfRange(a, l, m + 1);
        int[] R = java.util.Arrays.copyOfRange(a, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length) a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) a[k++] = L[i++];
        while (j < R.length) a[k++] = R[j++];
    }

    static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 6, 9, 10, 7};
        sort(a, 0, a.length - 1);
        System.out.println("Sorted Array:");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
