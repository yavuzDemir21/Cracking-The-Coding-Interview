package arraysandstrings;
/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/

import static util.ArrayUtils.printMatrix;

public class Question8 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,1}, {1,1,1},{1,1,1}};
        printMatrix(arr);
        zeroMatrix(arr);
        System.out.println();
        printMatrix(arr);
    }
    private static void zeroMatrix(int[][] matrix){
        setFirstRowAndColumnToZero(matrix);
        updateMatrix(matrix);
    }


    private static void setFirstRowAndColumnToZero(int[][] matrix) {
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
    }

    private static void updateMatrix(int[][] matrix) {
        for(int row=1; row<matrix.length; row++){
            if(matrix[row][0] == 0){
                updateRow(matrix, row);
            }
        }

        for(int col=1; col<matrix[0].length; col++){
            if(matrix[0][col] == 0){
                updateCol(matrix, col);
            }
        }

        if(matrix[0][0] == 0){
            updateRow(matrix, 0);
            updateCol(matrix, 0);
        }
    }

    private static void updateRow(int[][] matrix, int row) {
        for(int i=1; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }

    private static void updateCol(int[][] matrix, int col) {
        for(int i=1; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
}
