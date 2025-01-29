package com.leetcode;

import java.util.ArrayDeque;


/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/description/">Traping Rain Water at Leetcode</a>
 */
public class TrappingRainWaterMy implements TrappingRainWater {
//    private static final Logger log = LoggerFactory.getLogger(TrappingRainWater.class);

    //    n == height.length
    //    1 <= n <= 2 * 10^4   (20_000)
    //    0 <= height[i] <= 10^5 (100_000)
    public int trap(int[] height) {
        if (!validSize(height)) {
            throw new IllegalArgumentException("1 <= length <= 20_000");
        }
        //no water when max two heights
        if (height.length < 3) {
            return 0;
        }
        final Trap trap = new Trap();
        int totalWater = 0;
        int prevHeight = 0;
        for (int hIndex = 0; hIndex < height.length; hIndex++) {
            int rightHeight = height[hIndex];
            if (prevHeight >= rightHeight) { //descending, skip counting
                trap.descendOrFlat(rightHeight, hIndex);
                prevHeight = rightHeight;
                continue;
            }
            int waterInValley = trap.reducaValley(rightHeight, hIndex);
            totalWater += waterInValley;
            //log.info("hIdx={}, totalWater={}, lastAddedValley={}", hIndex, totalWater, waterInValley);
            prevHeight = rightHeight;
        }
        return totalWater;
    }

    private boolean validSize(int[] height) {
        return height != null && height.length != 0 && height.length <= 20_000;
    }

    static class Peak {
        int x;
        int height;

        public Peak(int height, int x) {
            if (height < 0 || x < 0) {
                throw new IllegalArgumentException("new Peek height=" + height + ", x=" + x);
            }
            this.height = height;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Peak{" +
                    "x=" + x +
                    ", height=" + height +
                    '}';
        }
    }

    static class Trap {

        private final ArrayDeque<Peak> leftSidePeaks = new ArrayDeque<>();
        private boolean hasValley = false;

        void descendOrFlat(int height, int x) {
            if (leftSidePeaks.isEmpty()) {
                leftSidePeaks.push(new Peak(height, x));
                return;
            }
            var previous = leftSidePeaks.peek();

            if (previous.height > height) {
                leftSidePeaks.push(new Peak(height, x));
                hasValley = true;
            } else {
                previous.x = x;
            }
        }

        int reducaValley(int height, int x) {
            if (leftSidePeaks.isEmpty()) {
                leftSidePeaks.push(new Peak(height, x));
                return 0;
            }
            if(!hasValley){
                var peak = leftSidePeaks.peek();
                peak.height = height;
                peak.x = x;
                return 0;
            }

            int waterInValley = 0;

            var ascendingLeft = leftSidePeaks.iterator();
            var abyss = ascendingLeft.next(); //first is deep
            while (ascendingLeft.hasNext() && abyss.height < height) {
                var leftPeak = ascendingLeft.next();
                int level = Math.min(height, leftPeak.height);
                if (level > abyss.height) {
                    var toAdd = (level - abyss.height) * (x - leftPeak.x - 1);
                    waterInValley += toAdd;
                    leftSidePeaks.pop(); //abyss removed
                }
                abyss = leftPeak;
            }
            if (abyss.height > height) {
                leftSidePeaks.push(new Peak(height, x));
            } else {
                abyss.height = height;
                abyss.x = x;
            }

            return waterInValley;
        }

        @Override
        public String toString() {
            return "Trap{" +
                    "leftSidePeaks=" + leftSidePeaks +
                    ", hasValley=" + hasValley +
                    '}';
        }
    }
}
