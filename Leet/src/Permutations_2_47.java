import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Permutations_2_47 {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int lengthCand;
    int candidates[];
    boolean visited[];
    HashMap<String, Boolean> hash = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        lengthCand = nums.length;
        candidates = new int[lengthCand + 1];
        candidates = nums;
       /// Arrays.sort(candidates);
        for (int i = 0; i < lengthCand; i++) {
            visited = new boolean[lengthCand + 1];
            findPermutation(i, new ArrayList<>(Arrays.asList(nums[i])), new ArrayList<>(Arrays.asList(i)), visited, candidates[i] + "");
        }
        return ans;
    }

    public void findPermutation(int root_ind, List<Integer> list, List<Integer> listIndex, boolean[] visited, String cust_str) {
        visited = new boolean[lengthCand + 1];
        for (int i = 0; i < list.size(); i++) {
            visited[listIndex.get(i)] = true;
        }
        if (list.size() == lengthCand) {
            if(hash.get(cust_str) == null){
                ans.add(list);
                hash.put(cust_str,true);
            }
            return;
        }
        for (int i = 0; i < lengthCand; i++) {
            if (!visited[i]) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(candidates[i]);

                List<Integer> tempIndex = new ArrayList<>(listIndex);
                tempIndex.add(i);
                findPermutation(i, temp, tempIndex, visited, cust_str + candidates[i]);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Permutations_2_47().permuteUnique(new int[]{}));
    }
}
