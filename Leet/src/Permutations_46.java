import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int lengthCand;
    int candidates[];
    boolean visited[];

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        lengthCand = nums.length;
        candidates = new int[lengthCand + 1];
        candidates = nums;
        for (int i = 0; i < lengthCand; i++) {
            visited = new boolean[lengthCand + 1];
            findPermutation(i, new ArrayList<>(Arrays.asList(nums[i])), new ArrayList<>(Arrays.asList(i)), visited);
        }
        return ans;
    }

    public void findPermutation(int root_ind, List<Integer> list, List<Integer> listIndex, boolean[] visited) {
        visited = new boolean[lengthCand + 1];
        for (int i = 0; i < list.size(); i++) {
            visited[listIndex.get(i)] = true;
        }
        if (list.size() == lengthCand) {
            ans.add(list);
            return;
        }
        for (int i = 0; i < lengthCand; i++) {
            if (!visited[i]) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(candidates[i]);
                List<Integer> tempIndex = new ArrayList<>(listIndex);
                tempIndex.add(i);
                findPermutation(i, temp, tempIndex, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations_46().permute(new int[]{}));
    }
}
