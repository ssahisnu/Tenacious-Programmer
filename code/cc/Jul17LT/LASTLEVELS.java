package cc.Jul17LT;

import java.util.Scanner;

public class LASTLEVELS {

    private static int LASTLEVELShelper(int x, int y, int z) {
        int pauseTime = (x%3==0) ? (x/3)-1 : (x/3);
        return (y*x) + (pauseTime*z);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            String inp = sc.nextLine();
            inp.trim();
            String[] vals = inp.split(" ");
            int x = Integer.parseInt(vals[0]);
            int y = Integer.parseInt(vals[1]);
            int z = Integer.parseInt(vals[2]);
            System.out.println(LASTLEVELShelper(x,y,z));
        }
    }
}
