package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static BigInteger[] dp = new BigInteger[100020];

    public static void main(String[] args) throws Exception {
        long hq = 1000000007l;
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        Scanner s = new Scanner(System.in);
        Long testCase = s.nextLong();
        for (int i = 1; i <= 100000; i++) {
            CalculateFactorialIterative(i);
        }
        for (int i = 0; i < testCase; i++) {
            int input = s.nextInt();
            System.out.println(dp[input].mod(BigInteger.valueOf(hq)));
        }
    }
    public static void CalculateFactorialIterative(int n) {
        if (dp[n - 1] != null) {
            dp[n] =  dp[n - 1].multiply(BigInteger.valueOf(n));
        }
    }
}


//        if(dp[n] != null){
//            return dp[n];
//        }
//        if(dp[n-1] != null){
//            return dp[n - 1].multiply(BigInteger.valueOf(n));
//        }
//        int k = 0;
//        while (dp[k] != null){
//            k++;
//        }
//        for (int i = k; i <= n; i++) {
//            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
//        }
//        return dp[n];
     /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT














  public static BigInteger CalculateFactorialRecursive(int n) {

        if (n == 1) {
            return BigInteger.ONE;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = CalculateFactorialRecursive(n - 1).multiply(BigInteger.valueOf(n));
        return dp[n];
    }


        */