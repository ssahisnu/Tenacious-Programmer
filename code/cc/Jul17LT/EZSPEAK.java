package sahisnu.code.cc.Jul17LT;

import java.util.Scanner;

public class EZSPEAK {

    private static final char[] VOWELS = {'a','e','i','o','u'};
    private static final String YES = "YES";
    private static final String NO = "NO";


    private static String EZSPEAKHelper(String str, int size) {
        if(size<4)
            return YES;

        char[] charArr = str.toCharArray();

        for(int i=0, j=0; i<size; ++i) {
            if(isVowel(charArr[i])) {
                j=i+1;
            }
            if (i-j+1 == 4)
                return NO;
        }
        return YES;
    }

    private static boolean isVowel(char c) {
        return (c-VOWELS[0]==0 ||
                c-VOWELS[1]==0 ||
                c-VOWELS[2]==0 ||
                c-VOWELS[3]==0 ||
                c-VOWELS[4]==0);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            int s = Integer.parseInt(sc.nextLine());
            String inp= sc.nextLine().trim();
            System.out.println(EZSPEAKHelper(inp, s));
        }
    }
}
