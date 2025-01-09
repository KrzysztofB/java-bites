package com.leetcode;

import java.util.Arrays;
/**
 * @see <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram at Leetcode</a>
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        var sArray = s.chars().sorted().toArray();
        var tArray = t.chars().sorted().toArray();
        return Arrays.equals(sArray, tArray);
        //fastest solution is int[](26), increment for letter, decrement for letter in second string
    }
}
