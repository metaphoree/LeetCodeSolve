import java.time.Duration;
import java.time.Instant;

public class K_ConcatenationMaximumSum_1191 {

    int len = 0;

    public int kConcatenationMaxSum(int[] arr, int k) {
        len = arr.length;
        if (len == 0) {
            return 0;
        }
        int countK = len;
        int sum = 0;
        int flag = 1000000007;
        int maxSum = 0;
        int end = 0;
        int start = 0;
        int count = 0;
        int tempCount = 0;
        for (int i = 0; i < countK; i++) {
            tempCount++;
            if (sum + arr[i] >= flag) {
                sum = (sum + arr[i]) % flag;
            } else {
                sum += arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                end = i;
                count = tempCount;
            }
            if (sum < 0) {
                sum = 0;
                tempCount = 0;
            }
        }
        start = end - count + 1;

        int distanceSum = 0;
        for (int i = 0; i < countK; i++) {
            if (i < start || i > end) {
                if (distanceSum + arr[i] >= flag) {
                    distanceSum = (distanceSum + arr[i]) % flag;
                } else {
                    distanceSum += arr[i];
                }
            }
        }

        if (distanceSum + maxSum <= 0) {
            return maxSum;
        }
        int finalSum = 0;
        for (int i = 0; i < k; i++) {
            if (finalSum + maxSum >= flag) {
                finalSum = (finalSum + maxSum) % flag;
            } else {
                finalSum += maxSum;
            }
            if (i == k - 1) {
                break;
            }

            if (finalSum + distanceSum >= flag) {
                finalSum = (finalSum + distanceSum) % flag;
            } else {
                finalSum += distanceSum;
            }
        }

       if(finalSum > maxSum){
            return finalSum;
       }
       return maxSum;
    }


    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println(new K_ConcatenationMaximumSum_1191().kConcatenationMaxSum(new int[]{4, 4}, 57011));

        Instant finish = Instant.now();
        double timeElapsed = (Duration.between(start, finish).toMillis());
        System.out.println("Time Needed : " + timeElapsed);

    }


}



















