import java.util.ArrayList;

public class LSWRC_3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] charac = new boolean[200];
        int start = 0, end = 0, maxLen = -1;
        int astart = 0;
        int aend = 0;

        for (int i = 0; i < s.length(); i++) {
            if (charac[s.charAt(i)] == false) {
                charac[s.charAt(i)] = true;
                end++;
            } else {
                int len = 0;
                len = end - start;

                if (len > maxLen) {
                    maxLen = len;
                    astart = start;
                    aend = end;
                }

                while (s.charAt(start) != s.charAt(i)) {
                    charac[s.charAt(start)] = false;
                    start++;
                }
                start++;
                end++;
            }
            //  System.out.println(start + " " + end);
        }
        int len = 0;
        len = end - start;
        if (len > maxLen) {
            maxLen = len;
            astart = start;
            aend = end;
        }
        return maxLen;
    }

    public static int maxArea_11(int[] height) {
        int max = -1;
        int start = 0, end = height.length - 1;
        while (start < end) {
            int result = 0, val = 0;
            boolean endBool = false;
            if (height[start] > height[end]) {
                val = height[end];
                endBool = true;
            } else {
                val = height[start];
                endBool = false;
            }
            result = val * Math.abs(end - start);
            max = Math.max(max, result);
            if (endBool) {
                end--;
            } else {
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // System.out.println(new LSWRC_3().
        // lengthOfLongestSubstring
        // ("abcdefghijklmnopqrstuvwxyz"));
        // System.out.println(maxArea_11(new int[]{1,8,6,2,5,4,8,3,7}));
        // System.out.println(maxArea_11(new int[]{3,1,2,10,10,3,1,1,2,10}));
        //System.out.println(maxArea_11(new int[]{1,2,1,1,6,2,4,1,1,3}));

    }
}
