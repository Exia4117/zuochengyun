package basic;

public class Code_06_PrintMatrixSpiralOrder {
    public static void spiralMatrix(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        int startX = 0;
        int startY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;
        while (startX <= endX && startY <= endY) {
            round(matrix, startX++, startY++, endX--, endY--);
        }

    }

    public static void round(int[][] matrix, int startX, int startY, int endX, int endY) {
        if (startX == endX) {
            for (int i = startY; i <= endY; i++) {
                System.out.print(matrix[startX][i] + " ");
            }
        } else if (startY == endY) {
            for (int i = startX; i <= endY; i++) {
                System.out.print(matrix[i][startY] + " ");
            }
        } else {
            int curX = startX;
            int curY = startY;
            while (curY < endY) {
                System.out.print(matrix[startX][curY++] + " ");
            }
            while (curX < endX) {
                System.out.print(matrix[curX++][endY] + " ");
            }
            while (curY > startY) {
                System.out.print(matrix[endX][curY--] + " ");
            }
            while (curX > startX) {
                System.out.print(matrix[curX--][startY] + " ");
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
//                {13, 14, 15, 16}};
        int[][] matrix = {};
        spiralMatrix(matrix);
    }
}
