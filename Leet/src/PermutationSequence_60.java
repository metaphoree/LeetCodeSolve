import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence_60 {

   // public List<String> ans = new ArrayList<String>();
    String strAns;
    int lengthCand;
    int nthAns;
    int candidates[];
    boolean visited[];
    int count = 0;
    boolean found = false;

    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        lengthCand = n;
        nthAns = k;
        for (int i = 1; i <= lengthCand; i++) {
            findPermutation(new ArrayList<>(Arrays.asList(i)), visited, i + "");
        }
        return strAns;
    }

    public void findPermutation(List<Integer> list, boolean[] visited, String cust_str) {
        if (found) {
            return;
        }
        visited = new boolean[lengthCand + 1];
        for (int i = 0; i < list.size(); i++) {
            visited[list.get(i)] = true;
        }
        if (list.size() == lengthCand) {
             // ans.add(cust_str);
            count++;
            if (count == nthAns) {
                strAns = cust_str;
                found = true;
            }
            return;
        }
        for (int i = 1; i <= lengthCand; i++) {
            if (!visited[i] && !found) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(i);
                findPermutation(temp, visited, cust_str + i);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new PermutationSequence_60().getPermutation(3,7));
    }
}
