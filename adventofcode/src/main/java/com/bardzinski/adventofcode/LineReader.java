package com.bardzinski.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class LineReader {
    private final String basePath;


    public LineReader(String basePath) {
        this.basePath = basePath;
    }


    public Stream<String> readLines(String file){
        Path fullPath = Paths.get(basePath, file).toAbsolutePath();
        try {
            return Files.lines(fullPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Stream.empty();

    }
    
}
