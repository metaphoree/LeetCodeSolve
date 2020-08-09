package LeetCode_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OnesAndZeroes_474 {
    int[] len0 = new int[700];
    int[] len1 = new int[700];
    int[] decimal;
    int ans = 0, i = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        int inputLen = strs.length;
        int realAns = 0;
        decimal = new int[inputLen];

        for (int j = 0; j < strs.length; j++) {
            decimal[j] = convertBinaryToDecimal(strs[j]);
        }
        Arrays.sort(decimal);
        String targetLow = "";
        String targetHigh = "";
        for (int i = 0; i < m; i++) {
            targetLow += "0";
            targetHigh += "0";
        }
        String temp = "";
        for (int j = 0; j < n; j++) {
            targetLow += "1";
            temp += "1";
        }
        targetHigh = temp + targetHigh;

        int low = convertBinaryToDecimal(targetLow);
        int high = convertBinaryToDecimal(targetHigh);



        int i = 0;
        while (decimal[i] >= low && decimal[i] <= high) {
            i++;
            ans++;
            realAns = 1;
        }
        int sum = decimal[i];

        int j = i;
        while (j < inputLen && i < inputLen) {
            if (decimal[i] > high) {
                sum -= decimal[i];
                i++;
            } else if (decimal[i] >= low && decimal[i] <= high) {
                ans++;
                if (j - i + 1 > realAns) {
                    realAns = j - i + 1;
                }
                sum -= decimal[i];
                i++;
                j++;
                if (j >= inputLen || i >= inputLen) {
                    break;
                }
                sum += decimal[j];
            } else if (sum < low) {
                j++;
                if (j >= inputLen || i >= inputLen) {
                    break;
                }
                sum += decimal[j];
            }
        }
        return realAns;
    }

    public void count(String str, int index) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                len0[index]++;
            } else if (str.charAt(i) == '1') {
                len1[index]++;
            }
        }
    }

    public int convertBinaryToDecimal(String binary) {
        int h = binary.length() - 1;
        int ans = 0;
        int count = 0;
        for (int j = h; j >= 0; j--) {
            if (binary.charAt(j) == '1') {
                ans += Math.pow(2, count) * 1;
            } else {
                ans += Math.pow(2, count) * 0;
            }
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new OnesAndZeroes_474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}


/*
    public int findMaxForm(String[] strs, int m, int n) {
        int inputLen = strs.length;
        int realAns = 0;
        while (len0[i] == m && len1[i] == n) {
            i++;
            count(strs[i], i);
            ans++;
            realAns = 1;
        }
        int sum0 = len0[i];
        int sum1 = len1[i];
        int j = i;
        while (j < inputLen && i < inputLen) {
            if (sum0 > m || sum1 > n) {
                sum0 -= len0[i];
                sum1 -= len1[i];
                i++;
            } else if (sum0 == m && sum1 == n) {
                ans++;
                if (j - i + 1 > realAns) {
                    realAns = j - i + 1;
                }
                sum0 -= len0[i];
                sum1 -= len1[i];
                i++;
                j++;
                if (j >= inputLen || i >= inputLen) {
                    break;
                }
                count(strs[j], j);
                sum0 += len0[j];
                sum1 += len1[j];
            } else if (sum0 < m && sum1 < n) {
                j++;
                if (j >= inputLen || i >= inputLen) {
                    break;
                }
                count(strs[j], j);
                sum0 += len0[j];
                sum1 += len1[j];
            }
        }
        return realAns;
    }


 */