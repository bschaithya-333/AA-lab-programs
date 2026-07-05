// 21. Quick Sort
public class P21_QuickSort {
    static int partition(int[] a, int low, int high) {
        int pivot = a[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (a[j] < pivot) { i++; int t = a[i]; a[i] = a[j]; a[j] = t; }
        int t = a[i + 1]; a[i + 1] = a[high]; a[high] = t;
        return i + 1;
    }

    static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 7, 1, 4, 10, 3};
        quickSort(a, 0, a.length - 1);
        System.out.println("Sorted Array:");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
