package com.bardzinski.adventofcode;

import java.util.stream.Stream;

public interface Task {
    String filePath();
    String solve(Stream<String> input);    
}
