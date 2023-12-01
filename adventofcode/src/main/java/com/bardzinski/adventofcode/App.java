package com.bardzinski.adventofcode;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bardzinski.adventofcode.aoc2023.A01a;

public class App {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().proceed();
	}

	public void proceed() {
		LOGGER.info("Hello World!");
		LineReader reader = new LineReader("adventofcode/src/main/resources");

		Task task = new A01a();
		String file = task.filePath();
		Stream<String> input = reader.readLines(file);
		String output = task.solve(input);
		LOGGER.info(output);
	}
}
