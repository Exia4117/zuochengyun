package basic;

import java.util.Arrays;

public class Comparator {
    public static void Sort(int[] arr) {
        Arrays.sort(arr);
    }

    public static int SmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return sum;
    }

}
