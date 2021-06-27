package github.zayn.leetcodexx.stack.leetcode21;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateParentheses
 * @DESCRIPTION 括号生成
 * @Author zhangjiayi07
 * @Date 2021/6/8 8:50 下午
 **/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, new StringBuilder(), 0, 0, ans);
        return ans;
    }

    public void backtrack(int max, StringBuilder cur, int left, int right, List<String> ans) {
        if (cur.length() >= max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append("(");
            backtrack(max, cur, left + 1, right, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(")");
            backtrack(max, cur, left, right + 1, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);
        System.out.println(strings);
    }
}
