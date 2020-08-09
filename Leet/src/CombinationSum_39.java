import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int targetCus;
    int lengthCand;
    int[] candidatesArr;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || target < 0) {
            return ans;
        }

        Arrays.sort(candidates);
        targetCus = target;
        lengthCand = candidates.length;
        candidatesArr = new int[lengthCand];
        candidatesArr = candidates;
        for (int i = 0; i < lengthCand; i++) {
            findCombSum(i, candidates[i], new ArrayList<>(Arrays.asList(candidates[i])), candidates[i]);
        }
        return ans;
    }

    public void findCombSum(int root_ind, int root_elm, List<Integer> list, int current_sum) {

        if (current_sum == targetCus) {
            ans.add(list);
            return;
        }
        if (current_sum + candidatesArr[root_ind] <= targetCus) {
            List<Integer> ls = new ArrayList<>(list);
            ls.add(candidatesArr[root_ind]);
            findCombSum(root_ind, candidatesArr[root_ind], ls, current_sum + candidatesArr[root_ind]);
        }
        if (root_ind + 1 == lengthCand) {
            return;
        }

        for (int i = root_ind + 1; i < lengthCand; i++) {
            if (current_sum + candidatesArr[i] <= targetCus) {
                List<Integer> ls = new ArrayList<>(list);
                ls.add(candidatesArr[i]);
                findCombSum(i, candidatesArr[i], ls,
                        current_sum + candidatesArr[i]);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Combinations_77().combine(4, 2));
    }

}
