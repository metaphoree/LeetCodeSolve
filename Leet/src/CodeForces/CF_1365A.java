package CodeForces;

import java.util.*;

public class CF_1365A {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[55][55];
        List<String> ans = new ArrayList<>();
        int testCaseNo = input.nextInt();
        HashSet<Integer> lstcol = new HashSet<Integer>();
        HashSet<Integer> lstrow = new HashSet<Integer>();
        for (int i = 0; i < testCaseNo; i++) {
            int row = input.nextInt();
            int col = input.nextInt();
            int chance = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    matrix[j][k] = input.nextInt();
                    if (matrix[j][k] == 1) {
                        lstcol.add(j);
                        lstrow.add(k);
                    }
                }
            }
            if (row == col) {
                chance = row - (lstcol.size() > lstrow.size() ? lstcol.size() : lstrow.size());
            } else if (row < col) {
                chance = row - (lstcol.size() > lstrow.size() ? lstcol.size() : lstrow.size());
            } else {
                chance = col - (lstcol.size() > lstrow.size() ? lstcol.size() : lstrow.size());
            }


            if (chance % 2 == 0) {
                ans.add("Vivek");
            } else if (chance % 2 == 1) {
                ans.add("Ashish");
            } else if (chance < 0) {
                ans.add("Vivek");
            }
            lstcol.clear();
            lstrow.clear();
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
