package basic;

public class Code_12_SmallSum {
    public static int SmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return smallSum(arr, 0, arr.length - 1);
    }

    public static int smallSum(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return smallSum(arr, L, mid) + smallSum(arr, mid + 1, R) + merge(arr, L, R, mid);
    }


    public static int merge(int[] arr, int L, int R, int mid) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int sum = 0;
        while (p1 <= mid && p2 <= R) {
            sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
//            System.out.print(help[i]);
//            System.out.print(" ");
        }
//        System.out.println(" ");

        return sum;

    }


    public static void main(String[] args) {
        int[] arr = {76, 12, 97, 77, 100, 6, 3, 90, 99, 83};
        System.out.println(SmallSum(arr));
    }
}


