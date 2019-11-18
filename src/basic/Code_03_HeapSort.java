package basic;

public class Code_03_HeapSort {

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void HeapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void Heapify(int[] arr, int index, int HeapSize) {
        int left = index * 2 + 1;
        while (left < HeapSize) {
            int largest = left + 1 < HeapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void HeapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            HeapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            Heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }
}
