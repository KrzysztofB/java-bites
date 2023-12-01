package com.bardzinski.adventofcode.aoc2023;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

import com.bardzinski.adventofcode.Task;

/* read text lines
 * take first and last DIGIT from each line
 * combine them to number
 * add numbers from each line
 * 1aasd2       -> 12
 * qw3e456gg8p  -> 38
 *     sum         50
 */
public class A01a implements Task {

    @Override
    public String filePath() {
        return "aoc2023/2023-01a.txt";
    }

    @Override
    public String solve(Stream<String> input) {
        int result = input
                .mapToInt(this::findNumber)
                .sum();
        return String.valueOf(result);

    }

    private int findNumber(String line) {
        AtomicInteger first = new AtomicInteger(-1);
        AtomicInteger last = new AtomicInteger(-1);

        IntConsumer useChar = (int c) -> {
            if (first.get() < 0) {
                first.set(c);
            } else {
                last.set(c);
            }
        };

        line.chars()
                .filter(Character::isDigit)
                .forEach(useChar);
        //change character codes to digit values
        first.addAndGet(-(int)'0');
        last.addAndGet(-(int)'0');

        if (last.get() < 0) {
            return 10 * first.get() + first.get();
        } else if (first.get() < 0) {
            return 0;
        } else {
            return 10 * first.get() + last.get();
        }
    }

}
