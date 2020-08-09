import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum_II_40 {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    HashMap<String, Integer> hash = new HashMap<>();
    int targetCus;
    int lengthCand;
    int[] candidatesArr;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0 || target < 0) {
            return ans;
        }
        Arrays.sort(candidates);
        targetCus = target;
        lengthCand = candidates.length;
        candidatesArr = new int[lengthCand];
        candidatesArr = candidates;
        for (int i = 0; i < lengthCand; i++) {
            if(candidates[i] > targetCus){
                continue;
            }
            findCombSum(i, candidates[i], new ArrayList<>(Arrays.asList(candidates[i])), candidates[i], candidates[i] + "");
        }
        return ans;
    }

    public void findCombSum(int root_ind, int root_elm, List<Integer> list, int current_sum, String custom_str) {
        if (current_sum == targetCus) {
            if (hash.get(custom_str) == null) {
                ans.add(list);
                hash.put(custom_str, 1);
            }
            return;
        }
        for (int i = root_ind + 1; i < lengthCand; i++) {
            if(current_sum + candidatesArr[i] > targetCus){
                continue;
            }
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidatesArr[i]);
            findCombSum(i, candidatesArr[i], temp, current_sum + candidatesArr[i], custom_str + candidatesArr[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum_II_40().combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27));
    }

/*
[14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12]
27
 */
}
