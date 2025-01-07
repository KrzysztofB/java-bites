package com.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWaterTest {

    private TrappingRainWater trappingWater;

    @BeforeEach
    void setup() {
        trappingWater = new TrappingRainWaterSpeed();
    }

    @Test
    void case1() {
        //given
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //when;
        int result = trappingWater.trap(height);
        //then
        assertThat(result).isEqualTo(6);
    }



    @Test
    void case18() {
        //given
        int[] height = {0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};
        //when;
        int result = trappingWater.trap(height);
        //then
        assertThat(result).isEqualTo(26);
    }

    @Test
    void case2(){

        //given
        int[] height = {4,2,0,3,2,5};
        //when;
        int result = trappingWater.trap(height);
        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void oneColumn() {
        //given
        int[] height = {7};
        //when;
        int result = trappingWater.trap(height);
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void flatArea() {
        //given
        int[] height = {5, 5, 5, 5};
        //when;
        int result = trappingWater.trap(height);
        //then
        assertThat(result).isEqualTo(0);
    }
}
