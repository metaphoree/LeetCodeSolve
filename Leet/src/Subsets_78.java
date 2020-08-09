import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Subsets_78 {


    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    HashMap<String, Integer> hash = new HashMap<>();

    public List<List<Integer>> subsets(int[] nums) {
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

        if (list.get(list.size() - 1) == last_val) {
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

        System.out.println(new Subsets_78().subsets(new int[]{1, 2, 3,7}));
    }






//        for (int i = 0; i < nums.length; i++) {
//            if (hash.get(nums[i] + "") == null) {
//                hash.put(nums[i] + "", 1);
//                ans.add(new ArrayList<Integer>(Arrays.asList(nums[i])));
//            }
//        }



//    int ind = 1;
//    List<Integer> tempList = new ArrayList<>(list);
//    int length3 = tempList.size();
//            while (ind != tempList.size()) {
//        List<Integer> ss = new ArrayList<>(tempList.subList(ind, length3));
//        ind++;
//        String sr = StrFromList(ss);
//        if (hash.get(sr) == null) {
//            hash.put(sr, 1);
//            ans.add(new ArrayList<Integer>(ss));
//        }
//    }


}
