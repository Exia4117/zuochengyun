package basic;
import java.util.Arrays;

class Code_02_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 23, 77, 2, 12, 55, 34, 87, 22 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}