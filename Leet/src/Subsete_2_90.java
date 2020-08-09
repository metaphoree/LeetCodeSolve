import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Subsete_2_90 {


    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    HashMap<String, Integer> hash = new HashMap<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<>());

        if (nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int last_val = nums[length - 1];
        for (int i = 0; i < nums.length; i++) {
            findSubset(nums, i, length, last_val,
                    new ArrayList<Integer>(Arrays.asList(nums[i])), nums[i] + "");
        }
        return ans;
    }

    public void findSubset(int[] arr, int root_ind, int length, int last_val, List<Integer> list, String cust_str) {

        if (root_ind == length - 1) {
            if (hash.get(cust_str) == null) {
                hash.put(cust_str, 1);
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        if (hash.get(cust_str) == null) {
            hash.put(cust_str, 1);
            ans.add(new ArrayList<Integer>(list));
        }
        for (int i = root_ind + 1; i < length; i++) {
            List<Integer> tmp = new ArrayList<Integer>(list);
            tmp.add(arr[i]);
            findSubset(arr, i, length, last_val, tmp, cust_str + arr[i]);
        }
    }

    public String StrFromList(List<Integer> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        return str;
    }


    public static void main(String[] args) {

        System.out.println(new Subsete_2_90().subsetsWithDup(new int[]{1, 2,2}));
    }
}