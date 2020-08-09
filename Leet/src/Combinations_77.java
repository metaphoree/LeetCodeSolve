import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> ans = new ArrayList<List<Integer>>();

    int noGiven;
    int length;

    public List<List<Integer>> combine(int nums, int k) {

        noGiven = nums;
        length = k;
        if (k == 0 ) {
            ans.add(new ArrayList<>());
            return ans;
        }
        int length = k;
        for (int i = 1; i <= nums; i++) {
            findSubset(i, 1, new ArrayList<>(Arrays.asList(i)));
        }
        return ans;
    }

    public void findSubset(int root_ind, int count, List<Integer> list) {

        if (count == length) {
            ans.add(list);
            return;
        }
        for (int i = root_ind + 1; i <= noGiven; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(i);
            int tempCount = count + 1;
            findSubset(i, tempCount, temp);
        }
    }

//    public void findSubset1(int root_ind, int noGiven, int length, List<Integer> list, String cust_str) {
//
//        if (list.size() == length) {
//            if (hash.get(cust_str) == null) {
//                hash.put(cust_str, 1);
//                ans.add(new ArrayList<Integer>(list));
//            }
//            return;
//        }
//        for (int i = root_ind + 1; i <= noGiven; i++) {
//            List<Integer> tmp = new ArrayList<Integer>(list);
//            tmp.add(i);
//            findSubset1(i, noGiven, length, tmp, cust_str + i);
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new Combinations_77().combine(4, 2));
    }


}