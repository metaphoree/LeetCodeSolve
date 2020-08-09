import java.time.Duration;
import java.time.Instant;

public class DecodeWays_91 {

    int globalCount = 1;
    int len = 0;
    String str;
    long dp[][];
    long flag = Integer.MAX_VALUE + 4;
    public int numDecodings(String s) {

        len = s.length();
        dp = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = flag;
            }
        }
        // str = s;
        if (s.isEmpty() || s.equals("0")) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                } else {
                    s = s.substring(0, i - 1) + "--" + s.substring(i + 1, len);
                }
            }
        }
        str = s;
        for (int i = len-1; i > 0; i--) {
            if (isValid(i-1, i )) {
                dp[i-1][i] = 1 + countDecode(i-1, i);
            }
            else{
                dp[i-1][i] = 0;
            }
            globalCount += dp[i-1][i];
        }
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                if(i >= j){
//                    System.out.print("(" + i + "," + j + ") => " + "NA" + " ");continue;
//                }
//                System.out.print("(" + i + "," + j + ") => " + dp[i][j] + " ");
//            }
//            System.out.println("\n");
//        }
        return globalCount;
    }

    public long countDecode(int i, int j) {
        if (j >= len || i >= len) {
            return 0;
        }
        if (dp[i][j] != flag) {
            return dp[i][j];
        }
        dp[i][j] = 0;
        for (int k = j + 1; k < len - 1; k++) {
            if (isValid(k, k + 1)) {
                dp[i][j] += countDecode(k, k + 1);
            }
        }
        return dp[i][j];
    }

    public boolean isValid(int i, int j) {
        String st = str.substring(i, i + 1) + str.substring(j, j + 1);
        if (st == "--") {

        } else if (st.charAt(0) == '-' || st.charAt(1) == '-') {
            return false;
        }
        if (Integer.valueOf(st) <= 26 && Integer.valueOf(st) > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
       // System.out.println(new DecodeWays_91().numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
       // System.out.println(new DecodeWays_91().numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
        System.out.println(new DecodeWays_91().numDecodings("2314321"));

        Instant finish = Instant.now();
        double timeElapsed = (Duration.between(start, finish).toMillis());
        System.out.println("Time Needed : " + timeElapsed);

    }
}
