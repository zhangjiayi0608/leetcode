package github.zayn.leetcodexx.stack.leetcode20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName ValidBracket
 * @DESCRIPTION 有效的括号
 * @Author zhangjiayi07
 * @Date 2021/6/3 7:51 下午
 **/
public class ValidBracket {
    Set<Character> LEFT_SET = Stream.of('(', '[', '{').collect(Collectors.toCollection(HashSet::new));

    public boolean isValid(String s) {
        int length = s.length();
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (LEFT_SET.contains(c)) {
                deque.addFirst(c);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char first = deque.pollFirst();
                if ('}' == c && '{' == first) {
                    continue;
                } else if (']' == c && '[' == first) {
                    continue;
                } else if (')' == c && '(' == first) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (!deque.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidBracket validBracket = new ValidBracket();
        String s = "[";
        boolean valid = validBracket.isValid(s);
        System.out.println(valid);
    }
}
