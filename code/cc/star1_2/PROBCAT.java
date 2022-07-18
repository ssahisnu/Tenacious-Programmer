package cc.star1_2;

import java.util.Scanner;

public class PROBCAT {

    private static final String EASY = "Easy";
    private static final String MEDIUM = "Medium";
    private static final String HARD = "Hard";

    private static String PROBCATSol(int taskRating) {

        if(taskRating<100)
            return EASY;
        else if(taskRating<200)
            return MEDIUM;
        else
            return HARD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-->0) {
            int inp = Integer.parseInt(sc.nextLine().trim());
            System.out.println(PROBCATSol(inp));
        }
    }
}
