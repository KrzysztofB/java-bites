package com.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddTwoNumbersTest {

    private AddTwoNumbers adder;

    @BeforeEach
    void setUp() {
        adder = new AddTwoNumbers();
    }

    @Test
    void example1() {
        //given
        var l1 = ListNode.of(2, 4, 3);
        var l2 = ListNode.of(5, 6, 4);
        var expected = ListNode.of(7, 0, 8);
        //when
        var result = adder.addTwoNumbers(l1, l2);
        //then
        assertTrue(result.equals(expected));
    }

    @Test
    void example2() {
        //given
        var l1 = ListNode.of(0);
        var l2 = ListNode.of(0);
        var expected = ListNode.of(0);
        //when
        var result = adder.addTwoNumbers(l1, l2);
        //then
        assertTrue(result.equals(expected));
    }

    @Test
    void example3() {
        //given
        var l1 = ListNode.of(9, 9, 9, 9, 9, 9, 9);
        var l2 = ListNode.of(9, 9, 9, 9);
        //var expected = ListNode.of(8,9,9,9,0,0,0,1);
        //when
        var result = adder.addTwoNumbers(l1, l2);
        //then
        assertThat(result.toList()).containsExactly(8, 9, 9, 9, 0, 0, 0, 1);
    }

}