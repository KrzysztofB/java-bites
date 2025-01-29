package com.bardzinski.adventofcode.aoc2023;

import com.bardzinski.adventofcode.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/* read text lines
 * take first and last DIGIT from each line
 * dogits can be written literaly one two three...
 * combine them to number
 * add numbers from each line
 * 1aasd2       -> 12
 * qw3e456gg8p  -> 38
 *     sum         50
 */
public class A01b implements Task {
    final Map<String, Integer> digits = Map.of("0", 0, "1", 1, "2", 2, "3", 3, "4", 4,
            "5", 5, "6", 6, "7", 7, "8", 8, "9", 9);
    final Map<String, Integer> words = Map.of(
            "zero", 0, "one", 1, "two", 2, "three", 3, "four", 4,
            "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);
    Map<String, Integer> items = combineDigitsAndWords();

    private Map<String, Integer> combineDigitsAndWords() {
        var map = new HashMap<String, Integer>(digits.size() + words.size());
        map.putAll(digits);
        map.putAll(words);
        return map;
    }


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
        first.addAndGet(-(int) '0');
        last.addAndGet(-(int) '0');

        if (last.get() < 0) {
            return 10 * first.get() + first.get();
        } else if (first.get() < 0) {
            return 0;
        } else {
            return 10 * first.get() + last.get();
        }
    }

}
