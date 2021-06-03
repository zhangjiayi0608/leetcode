package github.zayn.leetcodexx.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName phoneNumberCombine
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2021/6/2 8:26 下午
 **/
public class PhoneNumberCombine {
    public List<String> combine(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    public void backTrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char c = digits.charAt(index);
            String str = phoneMap.get(c);
            for (int i = 0; i < str.length(); i++) {
                combination.append(str.charAt(i));
                backTrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        PhoneNumberCombine combine = new PhoneNumberCombine();
        List<String> combine1 = combine.combine(digits);
        System.out.println(combine1);
    }

}
