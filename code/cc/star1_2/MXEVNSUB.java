package cc.star1_2;

import java.util.Scanner;

public class MXEVNSUB {

    // o + o = e; e + e = o; o + e = o
    // sum of 1 to n = n*(n+1)/2

    private static int MXEVNSUBSol(int N) {
        int sumOfN = ((N*(N+1))/2);
        return (sumOfN%2==0)? N : N-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            int inp = Integer.parseInt(sc.nextLine().trim());
            System.out.println(MXEVNSUBSol(inp));
        }
    }
}
