package arraysandstrings;
/*
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the
image by 90 degrees. Can you do this in place?

*/

import static util.ArrayUtils.printMatrix;

public class Question7 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {0,0,0}, {2,2,2}};
        printMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix);
        printMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix);
        printMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix);
        printMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix);
        printMatrix(matrix);
    }

    //Assume clockwise rotation
    private static void rotateMatrix(int[][] matrix){

        for(int i=0; i<matrix.length/2; i++){
            int len = matrix[0].length-i-1;
            for(int j=i; j<len; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j][i];
                matrix[len-j][i] = matrix[len-i][len-j];
                matrix[len-i][len-j] = matrix[j][len-i];
                matrix[j][len-i] = temp;


            }
        }

    }



}
