import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumProductSubarray_152 {
    int len = 0;
    int dp[];

    public int maxProduct(int[] nums) {
        len = nums.length;
        dp = new int[len];
        int lenTemp = len;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
            if (dp[i] > ans) {
                ans = dp[i];
            }
            for (int j = i + 1; j < len; j++) {
                dp[j] = dp[j - 1] * nums[j];
                if (dp[j] > ans) {
                    ans = dp[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        int[] arr = new int[]{3,1,1,1,5,1,2,1};
        System.out.println(new MaximumProductSubarray_152().maxProduct(arr));
        Instant finish = Instant.now();
        double timeElapsed = (Duration.between(start, finish).toMillis());
        System.out.println("Time Needed : " + timeElapsed);
    }

}
