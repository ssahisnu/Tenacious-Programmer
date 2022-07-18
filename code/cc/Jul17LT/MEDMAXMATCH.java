package sahisnu.code.cc.Jul17LT;

import java.util.*;

public class MEDMAXMATCH {

    private static long MEDMAXMATCHhelper(long[] boysArr, long[] girlsArr, int size) {
        long res = 0;
        for(int i=0; i<size; ++i) {
            ArrayList<Long> list = new ArrayList<>();
            int k=i;
            for(int j=0; j<size; ++j) {
                 list.add(boysArr[k]+girlsArr[j]);
                 k = (k+1)%size;
            }
            res = Math.max(res, findMedianInList(list, size));
        }
        return res;
    }

    private static long findMedianInList(List<Long> list, int sz) {
        Collections.sort(list);
        return list.get(sz/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            int s = Integer.parseInt(sc.nextLine());
            String boys= sc.nextLine().trim();
            String[] boysArr = boys.split(" ");
            long[] intBoysArr = new long[s];
            for(int i=0; i<s; ++i)
                intBoysArr[i] = Integer.parseInt(boysArr[i]);
            String girls= sc.nextLine().trim();
            String[] girlsArr = girls.split(" ");
            long[] intGirlsArr = new long[s];
            for(int i=0; i<s; ++i)
                intGirlsArr[i] = Integer.parseInt(girlsArr[i]);
            System.out.print(MEDMAXMATCHhelper(intBoysArr, intGirlsArr, s));
            if(n>0)
                System.out.println();
        }
    }
}
