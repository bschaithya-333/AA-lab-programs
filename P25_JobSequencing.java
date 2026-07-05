// 19. Insertion Sort
public class P19_InsertionSort {
    public static void main(String[] args) {
        int[] a = {8, 4, 6, 1, 3};
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) { a[j + 1] = a[j]; j--; }
            a[j + 1] = key;
        }
        System.out.println("Sorted Array:");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
