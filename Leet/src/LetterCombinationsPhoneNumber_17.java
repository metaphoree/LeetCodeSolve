import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber_17 {

    List<String> ans = new ArrayList<>();
    HashMap<String, ArrayList<String>> hash = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if (digits.isBlank() || digits.isEmpty() || digits.contains("1") || digits.contains("0")) {
            return ans;
        }
        String test = "";
        if (digits.contains("*")
                || digits.contains("#")) {
            for (int i = 0; i < digits.length(); i++) {
                if (digits.charAt(i) != '*' && digits.charAt(i) != '#') {
                    test += digits.charAt(i) + "";
                }
            }
            digits = test;
        }

        hash.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        hash.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        hash.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        hash.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        hash.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        hash.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        hash.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        hash.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        List<String> temp = hash.get(digits.charAt(0) + "");
        for (int i = 0; i < temp.size(); i++) {
            letterCombPhoneNumber(1, digits, temp.get(i) + "");
        }

        return ans;
    }

    public void letterCombPhoneNumber(int index, String main_str, String custom_str) {
        if (index == main_str.length()) {
            ans.add(custom_str);
            return;
        }

        List<String> temp = hash.get(main_str.charAt(index) + "");
        for (int i = 0; i < temp.size(); i++) {
            letterCombPhoneNumber(index + 1, main_str, custom_str + temp.get(i));
        }
    }


    public static void main(String[] args) {

        System.out.println(new LetterCombinationsPhoneNumber_17().letterCombinations("232323*"));
    }
}