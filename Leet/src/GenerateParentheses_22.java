import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GenerateParentheses_22 {

    List<String> ans = new ArrayList<>();

    int num = 0;
    public List<String> generateParenthesis(int n) {
        num = n;
        if (n == 0) {
            ans.add("");
            return ans;
        }
        generateCustomParen(1, 0, "(", 1);
        return ans;
    }
    public void generateCustomParen(int startBrace, int endBrace, String str, int strLength) {
        if (strLength == num*2) {
                ans.add(str);
        }
        for (int i = 0; i < startBrace - endBrace; i++) {
            generateCustomParen(startBrace, endBrace + 1, str + ")", strLength + 1);
            break;
        }
        for (int i = 0; i < num - startBrace; i++) {
            generateCustomParen(startBrace + 1, endBrace, str + "(", strLength + 1);
            break;
        }
    }


    public static void main(String[] args) {
        System.out.println(new GenerateParentheses_22().generateParenthesis(3));
    }
}
