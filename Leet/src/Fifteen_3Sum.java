import java.util.ArrayList;
import java.util.List;

public class Fifteen_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int len = nums.length;
        int i = -1, j = 0, k = 1;

        while (j < len) {
            i++;
            j++;
            k = j+1;
            if(k == len){break;}
            while (k < len) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                    ret.add(temp);
                }
                k++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {


    }
}
