package dsa_sheet.striver.arrays01;

//https://leetcode.com/problems/set-matrix-zeroes/submissions/

/* -------    Intuition    -------
  cant be solve it in a single loop as it leads to zero matrix,
  Matrix first row and column can be used as a storage to say if a row/col is 0
  In that case we need two other booleans to know if the first row/col can be zero
  can be confusing when handling the boolean vars
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        boolean isFirstRow0 = false;
        boolean isFirstCol0 = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) {
                if(matrix[i][j]==0) {
                    if(i==0) isFirstRow0 = true;
                    if(j==0) isFirstCol0 = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }
        }

        for(int rowIndex=rows-1; rowIndex>=0; --rowIndex) {
            for(int colIndex=cols-1; colIndex>=0; --colIndex) {

                if(rowIndex ==0) {
                    if(isFirstRow0)
                        matrix[rowIndex][colIndex]=0;
                } else if(colIndex==0) {
                    if(isFirstCol0)
                        matrix[rowIndex][colIndex]=0;
                } else {
                    if(matrix[rowIndex][0]==0 || matrix[0][colIndex]==0)
                        matrix[rowIndex][colIndex]=0;
                }
            }
        }

    }
}
