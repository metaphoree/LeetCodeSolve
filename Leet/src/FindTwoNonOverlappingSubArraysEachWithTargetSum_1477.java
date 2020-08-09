import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum_1477 {

    int len = 0;
    int targetCus = 0;
    int[] dp;
    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();

    public int minSumOfLengths(int[] arr, int target) {
        len = arr.length;
        dp = new int[len];
        targetCus = target;
        int lenTemp = len;
        int start = 0;
        int end = 0;
        int currentSum = 0;
        while (end != len) {
            currentSum += arr[end];
            if (currentSum == target && target == 0) {
                ans.add(new ArrayList<>(Arrays.asList(start, end, end - start + 1)));
                start++;
                end++;
                continue;
            }
            while (currentSum > target) {
                currentSum -= arr[start];
                start++;
                if (target == 0) {
                    break;
                }
                if (currentSum == target) {
                    ans.add(new ArrayList<>(Arrays.asList(start, end, end - start + 1)));
                    if (start == end) {
                        currentSum = 0;
                    } else {
                        currentSum -= arr[start];
                    }
                    start++;
                }
                if (currentSum < target || start == len) {
                    break;
                }
            }
            if (currentSum == target && target != 0) {
                ans.add(new ArrayList<>(Arrays.asList(start, end, end - start + 1)));
                if (start == end) {
                    currentSum = 0;
                } else {
                    currentSum -= arr[start];
                }
                start++;
            }
            end++;
        }

        ans.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(2) > o2.get(2)) {
                    return 1;
                } else if (o1.get(2) < o2.get(2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < ans.size(); i++) {
            for (int j = i + 1; j < ans.size(); j++) {
                if (!overLaps(ans.get(i).get(0), ans.get(i).get(1), ans.get(j).get(0), ans.get(j).get(1))) {
                    if (ans.get(i).get(2) + ans.get(j).get(2) < min) {
                        min = ans.get(i).get(2) + ans.get(j).get(2);
                    }
                    if (j - i == 1) {
                        found = true;
                    }
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public void Add(int i, int j) {
        ans.add(new ArrayList<>(Arrays.asList(i, j, j - i + 1)));
    }

    public boolean overLaps(int i, int j, int pre_i, int pre_j) {
        if (pre_i >= i && pre_i <= j) {
            return true;
        }
        if (pre_j >= i && pre_j <= j) {
            return true;
        }
        if (i >= pre_i && i <= pre_j) {
            return true;
        }
        if (j >= pre_i && j <= pre_j) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        // [3,1,1,1,5,1,2,1]
        // 3


        Instant start = Instant.now();
       // int[] arr = new int[]{1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8};
        int[] arr = new int[]{3,2,2,4,3};
        System.out.println(new FindTwoNonOverlappingSubArraysEachWithTargetSum_1477().minSumOfLengths(arr, 3));
        Instant finish = Instant.now();
        double timeElapsed = (Duration.between(start, finish).toMillis());
        System.out.println("Time Needed : " + timeElapsed);
    }
}
/*
[1,2,2,3,2,6,7,2,1,4,8]
5

   public int minSumOfLengths(int[] arr, int target) {
        len = arr.length;
        int[] lenArr = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = arr[i];
            if (sum == target) {
                if (1 < lenArr[0]) {
                    lenArr[1] = lenArr[0];
                    lenArr[0] = 1;
                } else if (1 == lenArr[0]) {
                    lenArr[1] = 1;
                }
                continue;
            }
            if(arr[i] == 9){
                System.out.println("khan");
            }
            for (int j = i + 1; j < len; j++) {
                sum += arr[j];
                if (sum == target) {
                    if ((j - i + 1) <= lenArr[0]) {
                        lenArr[1] = lenArr[0];
                        lenArr[0] = j - i + 1;
                    } else if ((j - i + 1) > lenArr[0] && (j - i + 1) < lenArr[1]) {
                        lenArr[1] = j - i + 1;
                    }
                    i = j;
                    break;
                }
            }
        }
        if (lenArr[0] == Integer.MAX_VALUE || lenArr[1] == Integer.MAX_VALUE) {
            return -1;
        }
        return lenArr[0] + lenArr[1];
    }
 */


// Iterative Solution with n square memory
//        for (int i = 0; i < len; i++) {
//            dp[i] = new int[lenTemp];lenTemp--;
//            dp[i][0] = arr[i];
//            if (dp[i][0] == target) {
//                ans.add(new ArrayList<>(Arrays.asList(i, i, i - i + 1)));
//            }
//        }
//        for (int j = len - 2; j >= 0; j--) {
//            for (int k = 0; k < dp[j].length-1; k++) {
//                dp[j][k + 1] = dp[j][0] + dp[j + 1][k];
//                if (dp[j][k + 1] == target) {
//                    ans.add(new ArrayList<>(Arrays.asList(j, k + 1 + j, k + 1 + j - j + 1)));
//                }
//            }
//        }
// RECUSSIVE SOLUTION
//    public void recurFunc(int i, int j, int sum) {
//        if (j == len) {
//            return;
//        }
//        if (sum == targetCus) {
//            Add(i, j);
//            if (j + 1 < len) {
//                recurFunc(j + 1, j + 1, sum + givenArr[j + 1]);
//            }
//        } else {
//            if (j + 1 < len) {
//                recurFunc(i, j + 1, sum + givenArr[j + 1]);
//            }
//        }
//    }


// Bottm Up Approach
//        dp[len - 1] = arr[len - 1];
//        if (dp[len - 1] == target) {
//            ans.add(new ArrayList<>(Arrays.asList(len - 1, len - 1, (len - 1) - (len - 1) + 1)));
//        }
//        for (int i = len - 2; i >= 0; i--) {
//            for (int j = len - 1; j >= i; j--) {
//                dp[j] = dp[j] + arr[i];
//                if (dp[j] == target) {
//                    ans.add(new ArrayList<>(Arrays.asList(i, j, j - i + 1)));
//                }
//            }
//        }


//TOP DOWN DP SOLUTION
/*
        for (int i = 0; i < len; i++) {
            dp[i] = arr[i];
            if (dp[i] == target) {
                ans.add(new ArrayList<>(Arrays.asList(i, i, i - i + 1)));
                continue;
            }
            for (int j = i+1; j < len; j++) {
                dp[j] = dp[j - 1] + arr[j];
                if(dp[j] > target) {break;}
                if (dp[j] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j, j - i + 1)));
                    break;
                }
            }
        }
 */