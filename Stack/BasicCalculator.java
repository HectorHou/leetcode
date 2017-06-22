package com.hm;

import java.util.Stack;
//224. Basic Calculator
//        DescriptionHintsSubmissionsSolutions
//        Discuss   Editorial Solution Pick One
//        Implement a basic calculator to evaluate a simple expression string.
//
//        The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
//
//        You may assume that the given expression is always valid.
//
//        Some examples:
//        "1 + 1" = 2
//        " 2-1 + 2 " = 3
//        "(1+(4+5+2)-3)+(6+8)" = 23
/**
 * Created by houming on 17-6-22.
 */
public class BasicCalculator {
    /*
    Solution: 1.use stack to store the result before '('
              2.add 1 or -1 to represent '+' or '-'
              3.combine the result when meet ')'
     */
    public int calculate(String s) {
        boolean isPositive = true;
        int i = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    i++;
                int num = Integer.parseInt(s.substring(j, i--));
                result += isPositive ? num : -num;
            } else if (curr == '+')
                isPositive = true;
            else if (curr == '-')
                isPositive = false;
            else if (curr == '(') {
                stack.push(result);
                result = 0;
                stack.push(isPositive ? 1 : -1);
                isPositive = true;
            } else if (curr == ')') {
                result = stack.pop() * result + stack.pop();
            }
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("1-(5)"));
    }
}
