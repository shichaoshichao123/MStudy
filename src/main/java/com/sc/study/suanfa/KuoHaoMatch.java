package com.sc.study.suanfa;

import java.util.*;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/8 9:52 下午
 * @desc 括号正确性匹配
 */
public class KuoHaoMatch {

    public static void main(String[] args) {
        String origin = "[[]]";
        String origin1 = "[[()]]";
        String origin2 = "[[(]]";
        String origin3 = "][(]]";
        String origin4 = "[[([[[[[{}]]]]])]]";

        System.out.println(origin);
        System.out.println(origin1);
        System.out.println(origin2);
        System.out.println(origin3);
        System.out.println(origin4);

    }

    /**
     * 进行括号匹配逻辑
     *
     * @param origin
     * @return
     */
    private static Boolean doMatch(String origin) {

        if (null == origin) {
            throw new IllegalArgumentException("入参不允许为空");
        }
        List<Character> characters = buildCharacterList(origin);
        //初始化一个匹配Map
        Map<Character, Character> matchMap = new HashMap<Character, Character>(8);
        matchMap.put(')', '(');
        matchMap.put('}', '{');
        matchMap.put(']', '[');
        //初始化一个栈
        Stack<Character> matchStack = new Stack<>();
        for (Character c : characters) {
            if (null == matchMap.get(c)) {
                //说明是左括号直接入栈
                matchStack.add(c);
            } else if (!matchStack.isEmpty() || matchMap.get(c).equals(matchStack.peek())) {
                //如果栈不为空并且该左括号与栈顶的元素能匹配，就将栈顶元素移除
                matchStack.pop();
            } else {
                return false;
            }
        }
        //如果都比较完了，确保匹配栈是空的
        return matchStack.isEmpty();

    }

    /**
     * 将字符串按字节转化成List
     *
     * @param origin
     * @return
     */
    private static List<Character> buildCharacterList(String origin) {
        if (null == origin) {
            return null;
        }
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < origin.length(); i++) {
            result.add(origin.charAt(i));
        }
        return result;

    }
}
