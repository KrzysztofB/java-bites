package com.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseIntegerTest {

    private ReverseInteger rev = new ReverseInteger();

    @ParameterizedTest
    @CsvSource(value = {"123,321", "-123,-321", "120,21", "1534236469,0"})
    void shouldReverseInt(int input, int expected) {
        //when
        int result = rev.reverse(input);
        //then
        assertThat(result).isEqualTo(expected);

    }

}