package uk.co.cjolive;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public abstract class Day {

    public long task1() {
        return task1(false);
    }

    public long task2() {
        return task2(false);
    }

    public abstract String getYear();

    public abstract long task1(boolean isTest);

    public abstract long task2(boolean isTest);

    protected Map<Integer, String> puzzleInputAsMap(boolean isTest) {
        Map<Integer, String> map = new HashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        puzzleInputStream(isTest).forEach(s -> map.put(atomicInteger.incrementAndGet(), s));
        return map;
    }

    protected Stream<String[]> puzzleInputStream(String split) {
        return puzzleInputStream(false).map(s -> s.split(split));
    }

    protected Stream<String[]> puzzleInputStream(String split, boolean isTest) {
        return puzzleInputStream(isTest).map(s -> s.split(split));
    }

    protected Stream<String> puzzleInputStream() {
        return puzzleInputStream(false);
    }

    protected Stream<String> puzzleInputStream(boolean isTest) {
        String filename = getFilename(isTest);
        return fileAsStringStream(filename);
    }

    protected Scanner puzzleInputScanner(boolean isTest) {
        try {
            String filename = getFilename(isTest);
            File f = new File(
                    this.getClass().getClassLoader().getResource(filename).toURI());
            return new Scanner(f);
        } catch (Exception e) {
            throw new RuntimeException("error.scanner.creation");
        }
    }

    private String getFilename(boolean isTest) {
        return getYear() + File.separator + this.getClass().getSimpleName().toLowerCase() + (isTest ? "-test" : "") + ".txt";
    }

    private Stream<String> fileAsStringStream(String filename) {
        try {
            Path path = Paths.get(
                    this.getClass().getClassLoader().getResource(filename).toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Could not read file", e);
        }
    }
}
