package com.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer at Leetcode</a>
 */
public class ReverseInteger {

    // return 123-> 321, -123-> -321, 0 in case of overflow/underflow
    public int reverse(int x) {
        int num = x;
        int result = 0;
        try {
            while (num != 0) {
                int digit = num % 10;
                int temp = Math.multiplyExact(result, 10);
                result = Math.addExact(temp, digit);
                num = num / 10;
            }
            return result;
        } catch (ArithmeticException ex) {
            return 0;
        }
    }
}
