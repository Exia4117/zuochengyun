package basic;

public class Code_05_RotateMatrix {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int startR = 0;
        int startC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        while (startR <= endR) {
            rotateEdge(matrix, startR++, startC++, endR--, endC--);
        }
    }

    public void rotateEdge(int[][] matrix, int startR, int startC, int endR, int endC) {
        int times = endC - startC;
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = matrix[endR - i][startC];
            matrix[endR - i][startC] = matrix[endR][endC - i];
            matrix[endR][endC - i] = matrix[startR + i][endC];
            matrix[startR + i][endC] = matrix[startR][startC + i];
            matrix[startR][startC + i] = tmp;
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Code_05_RotateMatrix test = new Code_05_RotateMatrix();
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        test.printMatrix(matrix);
        test.rotate(matrix);
        test.printMatrix(matrix);
    }
}
