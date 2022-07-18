package cc.Jul17LT;

import java.util.Scanner;

public class MAKEPALAGAIN {

    private static final String YES = "YES";
    private static final String NO = "NO";

    private static String MAKEPALAGAINhelper(String s, int size) {
        int[] charMap  = new int[26];
        char[] charArr = s.toCharArray();
        for(int i=0; i<size; ++i) {
            if(i%2==0)
                charMap[charArr[i]-'a']--;
            else
                charMap[charArr[i]-'a']++;
        }
        return checkForZeroArray(charMap) ? YES : NO;
    }

    private static boolean checkForZeroArray(int[] charMap) {
        for(int i: charMap) {
            if(i!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            int s = Integer.parseInt(sc.nextLine());
            String inp= sc.nextLine().trim();
            System.out.println(MAKEPALAGAINhelper(inp, s));
        }
    }
}
