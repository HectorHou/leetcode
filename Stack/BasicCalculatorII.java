package com.hm;

import java.util.LinkedList;
//227. Basic Calculator II
//        DescriptionHintsSubmissionsSolutions
//        Discuss   Editorial Solution Pick One
//        Implement a basic calculator to evaluate a simple expression string.
//
//        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
//        You may assume that the given expression is always valid.
//
//        Some examples:
//        "3+2*2" = 7
//        " 3/2 " = 1
//        " 3+5 / 2 " = 5
//        Note: Do not use the eval built-in library function.
/**
 * Created by houming on 17-6-22.
 */
public class BasicCalculatorII {
    /*
    Solution: 1.use two linkedlist to store the numbers and operators.
              2.'*' and '/' operate immediately; '+' and '-' operate later.
     */
    public int calculate(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> operStack = new LinkedList<>();
        boolean isOperate = false;
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                int j = i;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    i++;
                int num = Integer.parseInt(s.substring(j, i--));
                if (isOperate)
                    numStack.push(operate(num, numStack.pop(), operStack.pop()));
                else
                    numStack.push(num);
            } else if (curr == '-' || curr == '+') {
                operStack.push(curr);
                isOperate = false;
            } else if (curr == '*' || curr == '/') {
                operStack.push(curr);
                isOperate = true;
            }
            i++;
        }

        while (numStack.size() > 1)
            numStack.offerLast(operate(numStack.pollLast(), numStack.pollLast(), operStack.pollLast()));
        return numStack.pop();
    }

    private int operate(int num1, int num2, char oper) {
        if (oper == '-')
            return num1 - num2;
        else if (oper == '+')
            return num2 + num1;
        else if (oper == '/')
            return num2 / num1;
        else
            return num2 * num1;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate(" 3/2 -3+2*2"));
    }
}
