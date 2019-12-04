package basic;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Code_08_ZigZagPrintMatrix {
    public static int[] findDiagonalOrder(int[][] matrix) {
        // if(matrix.length == 0){
        // return
        // }
        int[] re = new int[matrix.length * matrix[0].length];
        ArrayList<Integer> reArray = new ArrayList<>();

        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean flag = true;
        while (aR <= endR) {
            ArrayList<Integer> tmp = DiagonalOrder(matrix, aR, aC, bR, bC, flag);
            reArray.addAll(tmp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;/*注意顺序！！！*/
            bR = bR == endR ? bR : bR + 1;
            flag = !flag;
        }
        for (int i = 0; i < reArray.size(); i++) {
            re[i] = reArray.get(i);
        }
        return re;
    }

    public static ArrayList<Integer> DiagonalOrder(int[][] matrix, int aR, int aC, int bR, int bC, boolean flag) {
        ArrayList<Integer> re = new ArrayList<>();
        if (flag) {
            while (bR >= aR) {
                re.add(matrix[bR--][bC++]);
            }
        } else {
            while (aR <= bR) {
                re.add(matrix[aR++][aC--]);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
        for(int i : findDiagonalOrder(matrix)){
            System.out.print(i + " ");
        }
    }
}
