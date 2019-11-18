package basic;

public class Code_05_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sortProcess(arr, 0, arr.length - 1);

    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);       //防止溢出
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;  //i是用来遍历辅助数组的
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {  //停止条件
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {     //默认p2越界
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {     //默认p1越界
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }

    }
}
