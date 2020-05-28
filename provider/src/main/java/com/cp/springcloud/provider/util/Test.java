package com.cp.springcloud.provider.util;

import java.util.HashMap;
import java.util.Stack;

public class Test {
    private static final String TEST_STRING = "([])";
    private static HashMap<Character, Character> map = new HashMap<Character, Character>();

    public static void main(String[] args) {
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        boolean result = vaild(TEST_STRING);
        System.out.println("string match is=" + result);
    }

    private static boolean vaild(String string) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (map.containsValue(ch)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
