package lc.daily;

//https://leetcode.com/problems/k-inverse-pairs-array/

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<n+1; ++i) {
            for(int j=0; j<k+1; ++j){
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    int tmp = (dp[i-1][j] + MOD - ((j-i) >= 0 ? dp[i-1][j-i] : 0)) % MOD;
                    dp[i][j]= (dp[i][j-1] + tmp) % MOD;
                }
            }
        }



        return ((dp[n][k] + MOD - (k > 0 ? dp[n][k - 1] : 0)) % MOD);
    }

    // if nums array is empty -> 0 combinations
    // if k==0 ie not inverse pairs -> 1 combination for any nums.size()

    // for (n, k) -> sumof(n-1, w) where w -> 0 to min(n-1, k)

    int MOD = 1_000_000_007;
    private int kInversePairsRecurse(int n, int k, Integer[][] dp) {  // 3,1

        if(n==0)
            return 0;

        if(k==0)
            return 1;

        if(dp[n][k]!=null)
            return dp[n][k];

        int sum=0;
        for(int i=0; i<=Math.min(n-1, k); ++i) {     // 0 to min(2,1)-1
            sum = (sum+kInversePairsRecurse(n-1, k-i, dp)) % MOD;
        }

        return dp[n][k]=sum;
    }
}

//    (3, 1)
// (2,0) + (2,1)     -> 2
//    =1    (1, 0) + (1, 1)
//              =1.     (0,0)
//                          =0





//     (3, 2)
// (2, 0) (2, 1) (2, 2)//cannot happen


//      (2,2)
//  (1,2)    (1, 1)
// (0, 2)             =0
