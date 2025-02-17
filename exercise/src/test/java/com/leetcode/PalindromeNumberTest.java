package com.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeNumberTest {

    private PalindromeNumber pn;

    @BeforeEach
    void setUp() {
        pn = new PalindromeNumber();
    }


    @ParameterizedTest
    @CsvSource({"0", "9", "191", "98766789"})
    void isPalindrome(int input) {

        //when
        boolean result = pn.isPalindrome(input);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"23", "233", "1110", "-121"})
    void notPalindrome(int input) {

        //when
        boolean result = pn.isPalindrome(input);
        //then
        assertFalse(result);
    }
}