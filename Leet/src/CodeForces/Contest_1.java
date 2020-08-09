package CodeForces;

import java.util.Scanner;

public class Contest_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();


            int count = 0;
            int ansCountA = 0;
            int ansCountB = 0;
            int tempB = b;
            int tempC = c;
            while (true) {
                count++;
                int price_1 = count * a;
                if (count > tempB) {
                    tempB += b;
                    tempC += c;
                }
                if((count * a) > tempC){
                    ansCountA = count;
                    ansCountB = tempB;break;
                }
            }
            ansCountA = ansCountA == 1  ? -1 : ansCountA;
            System.out.println(ansCountA + " " + ansCountB);
        }


        // System.out.println(new BinaryTreeLevelOrderTraversal_102().);
    }
}
