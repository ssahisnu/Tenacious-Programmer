package lc.daily;

import java.util.Arrays;

//https://leetcode.com/problems/out-of-boundary-paths/

public class OutofBoundaryPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int[][][] dp = new int[m][n][maxMove+1];

        for(int[][] r: dp)
            for(int[] c: r)
                Arrays.fill(c, -1);

        return dfsHelper(m, n, maxMove, startRow, startColumn, dp);

    }

    int MOD = 1000_000_007;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    private int dfsHelper(int m, int n, int maxMove, int row, int col, int[][][] dp) {

        if(row<0 || row>=m || col<0 || col>=n)
            return 1;

        if(maxMove==0)
            return 0;

        if(dp[row][col][maxMove]!=-1) {
            return dp[row][col][maxMove];
        }

        return dp[row][col][maxMove] = (
                (
                        (dfsHelper(m, n, maxMove-1, row+dx[0], col+dy[0], dp)
                                + dfsHelper(m, n, maxMove-1, row+dx[1], col+dy[1], dp))
                                % MOD
                )
                        +
                        (
                                (dfsHelper(m, n, maxMove-1, row+dx[2], col+dy[2], dp)
                                        +dfsHelper(m, n, maxMove-1, row+dx[3], col+dy[3], dp))
                                        % MOD
                        )
        ) % MOD;

    }
}
