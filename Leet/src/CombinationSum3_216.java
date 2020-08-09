import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum3_216 {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();

    int targetCus;
    int lengthCand;
    int[] candidates;
    int noLevel;

    public List<List<Integer>> combinationSum3(int k, int n) {
        candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (n == 0 || k < 0) {
            return ans;
        }
        noLevel = k;
        targetCus = n;
        lengthCand = 9;
        for (int i = 0; i < lengthCand; i++) {
            if (candidates[i] > targetCus) {
                continue;
            }
            findCombSum(i, new ArrayList<>(Arrays.asList(candidates[i])), candidates[i], 1);
        }
        return ans;
    }

    public void findCombSum(int root_ind, List<Integer> list, int current_sum, int count) {
        if (count == noLevel) {
            if (current_sum == targetCus) {
                ans.add(list);
            }
            return;
        }
        for (int i = root_ind + 1; i < lengthCand; i++) {
            if (current_sum + candidates[i] > targetCus) {
                continue;
            }
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[i]);
            findCombSum(i, temp, current_sum + candidates[i], count + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3_216().combinationSum3(3, 9));
    }
}
