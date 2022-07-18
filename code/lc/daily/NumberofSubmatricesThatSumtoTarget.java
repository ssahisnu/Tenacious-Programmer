package lc.daily;

import java.util.*;

//https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
public class NumberofSubmatricesThatSumtoTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {


//-----------------------------------------------------------------------------------------//
        //pre-requsite
        //Subarray sum for a array -> prefix sum + hashMap


        //intution
        //same as subarray sum, for a 2d array

        //[
        //     [0,1,0]
        //     [1,1,1]
        //     [0,1,0]
        // ]
        //prefix sum for each row
        //[
        //     [0,1,1]
        //     [1,2,3]
        //     [0,1,1]
        // ]

        //for(i -> 1 to column)    starting column
        //  for(j ->i to column)   ending column (i=j when one single column is considered)
        //      for(k -> 1 to row)  for every row for each column combination ->

        // sub-matrix of a single row is ensured -> i = a ; j = b ; k=1 ()
        // sub-matrix of a single column is ensured -> i = a ; j = a ; k=1 to row ()
        // sub-matrix of

        // TC - for each col - for each col - for each row  => O(col*col*row)
        // SC
//-----------------------------------------------------------------------------------------//

        //calculate prefix sum
        int row = matrix.length;
        if(row==0)
            return 0;
        int col = matrix[0].length;
        for(int i=0; i<row; ++i) {
            for(int j=1; j<col; ++j) {
                matrix[i][j] += matrix[i][j-1];
            }
        }

        //iteration
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(row);

        for(int i=0; i<col; ++i) {
            for(int j=i; j<col; ++j) {

                map.clear();
                int curSum = 0;
                for(int k =0; k<row; ++k) {
                    //maintain a hashmap to break between rows in the cur col range
                    curSum+= (matrix[k][j] - ((i-1>=0) ? matrix[k][i-1] : 0));
                    res = (curSum==target) ? res+1 : res;
                    res += map.getOrDefault(curSum-target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0)+1);
                }

            }
        }


        return res;
    }
}
