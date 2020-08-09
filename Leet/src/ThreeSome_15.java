import java.util.*;

public class ThreeSome_15 {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return ans;
        } else if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            ans.add(new ArrayList<>(Arrays.asList(0,0,0)));
            return ans;
        } else if (nums[0] >= 0) {
            return ans;
        } else if (nums[nums.length - 1] < 0) {
            return ans;
        }
        int zeroCount = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == 0){
                zeroCount++;
            }
        }
        ThreeSum_15(nums);
        if(zeroCount >= 3 ){
            ans.add(new ArrayList<>(Arrays.asList(0,0,0)));
        }

        return ans;
    }

    public void ThreeSum_15(int[] arr) {
        HashMap<String, Integer> hash = new HashMap<>();
        int i = 0;
        int j = arr.length - 1;
        while (arr[i] < 0) {
            while (arr[j] >= 0) {
                if (arr[i] + arr[j] <= 0) {
                    int k = j - 1;
                    while (arr[k] >= 0) {
                        if (arr[i] + arr[j] + arr[k] == 0) {
                            if (hash.get(arr[i] + "" + arr[k] + " " + arr[j]) != null) {
                                break;
                            }
                            hash.put(arr[i] + "" + arr[k] + " " + arr[j], 1);
                            ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[k], arr[j])));
                            break;
                        }
                        k--;
                    }
                }
                j--;
            }
            i++;
            j = arr.length - 1;
        }
        i = 0;
        j = arr.length - 1;
        while (arr[j] >= 0) {
            while (arr[i] < 0) {
                if (arr[i] + arr[j] > 0) {
                    int k = i + 1;
                    while (arr[k] < 0) {
                        if (arr[i] + arr[j] + arr[k] == 0) {
                            if (hash.get(arr[i] + "" + arr[k] + " " + arr[j]) != null) {
                                break;
                            }
                            hash.put(arr[i] + "" + arr[k] + " " + arr[j], 1);
                            ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[k], arr[j])));
                            break;
                        }
                        k++;
                    }
                }
                i++;
            }
            j--;
            i = 0;
        }
    }


    public static void main(String[] args) {
        /*
        [ -1, 0, 1, 2, -1, -4 ]
        [ -5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10 ]
        [ 0,1,2,3,4,5,6,7,8,9,10 ]
        [ -1,0,1,2,3,4,5,6,7,8,9,10 ]
        [ -1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10 ]
        [ -10,0,1,2,3,4,5,6,7,8,9,10 ]
        [ -10,0,1,2,3,4,5,5,6,7,8,9,10 ]
        []
        [ -16,0,1,8,8,15,16 ]
        [-7,0,1,8,8,15,16]
        [0,0,0,0,0,0,0,0,0,0,0]

        [ -5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9,10 ]
         */
        int[] input = new int[]{ -5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9,10};
        System.out.println(new ThreeSome_15().threeSum(input));
    }
}
