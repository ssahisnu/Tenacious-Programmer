package sahisnu.code.cc.Jul17LT;

import java.util.*;

public class LARGEFAM {

    private static int LARGEFAMhelper(int[] arr, int ind, int sum, int count, int[][] dp) {
        if(sum==0) {
            return count;
        }
        if(ind<0)
            return 0;
        if(dp[ind][sum]!=-1)
            return dp[ind][sum];
        //take
        int val = 0;
        if(sum-arr[ind]>=0)
            val = LARGEFAMhelper(arr, ind-1, sum-arr[ind], count+1, dp);
        //not-take
        return dp[ind][sum] = Math.max(LARGEFAMhelper(arr, ind-1, sum, count, dp), val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            int s = Integer.parseInt(sc.nextLine());
            String inp= sc.nextLine().trim();
            String[] arr = inp.split(" ");
            int[] intArr = new int[s];
            for(int i=0; i<s; ++i)
                intArr[i] = Integer.parseInt(arr[i]);
            int[][] dp = new int[s][s];
            for(int[] i: dp)
                Arrays.fill(i, -1);
            System.out.println(LARGEFAMhelper(intArr, s-1, s-1, 0, dp));
        }
    }
}
