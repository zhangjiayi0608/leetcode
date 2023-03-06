package github.zayn.leetcodexx.stack.rpn;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName RPN
 * @DESCRIPTION 逆波兰表达式
 * @Author zhangjiayi07
 * @Date 2021/5/28 5:35 下午
 **/
public class RPN {
    private static final Set<String> SYMBOL_SET = Stream.of("+", "-", "*", "/", "(", ")").collect(Collectors.toCollection(HashSet::new));

    private static final Set<String> LOW_WEIGHT_SET = Stream.of("+", "-").collect(Collectors.toCollection(HashSet::new));

    private static final Set<String> HIGH_WEIGHT_SET = Stream.of("*", "/").collect(Collectors.toCollection(HashSet::new));


    public static void main(String[] args) {
        Deque<String> symbolDeque = new LinkedList<>();
        String str = "a*(b-c*d)+e";
        StringBuilder targetStrBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String curStr = Character.toString(str.charAt(i));
            if (!SYMBOL_SET.contains(curStr)) {
                targetStrBuilder.append(curStr);
            } else if ("(".equals(curStr) || symbolDeque.isEmpty()||"(".equals(symbolDeque.peekFirst())) {
                symbolDeque.push(curStr);
            } else if (LOW_WEIGHT_SET.contains(curStr) && HIGH_WEIGHT_SET.contains(symbolDeque.peekFirst())) {
                targetStrBuilder.append(symbolDeque.pollFirst());
            } else if (")".equals(curStr)) {
                String s = symbolDeque.pollFirst();
                while (!"(".equals(s)) {
                    targetStrBuilder.append(s);
                }
            } else {
                targetStrBuilder.append(curStr);
            }
        }
        System.out.println(targetStrBuilder.toString());

    }
}
