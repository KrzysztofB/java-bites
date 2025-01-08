package com.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        long source = x;
        long bcd = 0;
        long bcdReversed = 0;
        long shift = 0L;
        while (source > 0) {
            long lowBits = source % 10L;
            bcd += lowBits << shift;
            bcdReversed <<= 4L;
            bcdReversed += lowBits;
            source /= 10L;
            shift += 4L;
        }
        return bcd == bcdReversed;
    }
}
