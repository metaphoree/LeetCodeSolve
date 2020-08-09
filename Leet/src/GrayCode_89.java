import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GrayCode_89 {

    // 1-- visited 2--explored
    HashMap<String, Integer> hash = new HashMap<>();
    List<String> ans = new ArrayList<>();
    int input = 0;
    int destCount = 0;
    int globalCount = 0;
    boolean found = false;

    public List<Integer> grayCode(int n) {
        input = n;
        if(n == 0){
            return new ArrayList<>(Arrays.asList(0));
        }
        destCount = (int) Math.pow(2, n);
        String start = "";
        for (int i = 0; i < n; i++) {
            start += "0";
        }
        hash.put(start,1);
        generateGrayCode(new ArrayList<Integer>(), start, new boolean[n]);
        List<Integer> finalAns = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            int foo = Integer.parseInt(ans.get(i), 2);
            finalAns.add(foo);
        }
        return finalAns;
    }

    public void generateGrayCode(List<Integer> indexLst, String cust_str, boolean[] visited) {
        if (found) {
            return;
        }
        if (hash.get(cust_str) == 1) {
            hash.put(cust_str, 2);
        } else if (hash.get(cust_str) == 2) {
            return;
        }
        visited = new boolean[input];
        for (int i = 0; i < indexLst.size(); i++) {
            visited[indexLst.get(i)] = true;
        }

        for (int i = 0; i < input; i++) {
            if (!visited[i]) {
                String fliped = flip(cust_str, i);
                if (hash.get(fliped) == null && !found) {
                    List<Integer> temp = new ArrayList<>(indexLst);
                    temp.add(i);hash.put(fliped, 1);

                    // ans.add(flipedf);
                    globalCount++;
                    if (destCount == globalCount) {
                        found = true;
                        return;
                    }
                    generateGrayCode(temp, fliped, visited);
                }
            }
        }
    }

    public String flip(String strToFlip, int index) {
        String tempRet = "";
        for (int i = 0; i < strToFlip.length(); i++) {
            if (strToFlip.charAt(i) == '0') {
                tempRet = strToFlip.substring(0, index) + '1' + strToFlip.substring(index+1);
            } else if (strToFlip.charAt(i) == '1') {
                tempRet = strToFlip.substring(0, index) + '0' + strToFlip.substring(index+1);
            }
        }
        return tempRet;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode_89().grayCode(2));

    }
}
