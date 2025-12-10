package uk.co.cjolive.adventofcode2025;

import java.util.ArrayList;
import java.util.List;
import uk.co.cjolive.Day;

public class Day4 extends Day {

    private static final int PADDING = 1;

    @Override
    public long task1(boolean isTest) {
        List<String> input = puzzleInputStream(isTest).toList();
        int stringLength = input.getFirst().length();
        List<String> padded = new ArrayList<>();
        padded.addAll(paddingLines(stringLength));
        padded.addAll(input.stream()
                .map(s -> {
                    return "." + s + ".";
                })
                .toList());
        padded.addAll(paddingLines(stringLength));

        List<char[]> charList = padded.stream().map(s -> s.toCharArray()).toList();
        char[][] charArray = charList.toArray(new char[charList.size()][]);

        final char SEARCH_CHAR = '@';

        long accessible = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                if (charArray[i][j] == '@') {
                    long paperFound = 0;
                    // right
                    if (charArray[i][j + 1] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // left
                    if (charArray[i][j - 1] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // up
                    if (charArray[i - 1][j] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // down
                    if (charArray[i + 1][j] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // diag left up
                    if (charArray[i - 1][j - 1] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // diag left down
                    if (charArray[i + 1][j - 1] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // diag right up
                    if (charArray[i - 1][j + 1] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    // diag right down
                    if (charArray[i + 1][j + 1] == SEARCH_CHAR) {
                        paperFound++;
                    }
                    if (paperFound < 4) accessible++;
                }
            }
        }
        return accessible;
    }

    @Override
    public long task2(boolean isTest) {
        List<String> input = puzzleInputStream(isTest).toList();
        int stringLength = input.getFirst().length();
        List<String> padded = new ArrayList<>();
        padded.addAll(paddingLines(stringLength));
        padded.addAll(input.stream()
                .map(s -> {
                    return "." + s + ".";
                })
                .toList());
        padded.addAll(paddingLines(stringLength));

        List<char[]> charList = padded.stream().map(s -> s.toCharArray()).toList();
        char[][] charArray = charList.toArray(new char[charList.size()][]);

        final char SEARCH_CHAR = '@';

        int accessible;
        long total = 0;
        do {
            accessible = 0;
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < charArray[i].length; j++) {
                    if (charArray[i][j] == '@') {
                        long paperFound = 0;
                        // right
                        if (charArray[i][j + 1] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // left
                        if (charArray[i][j - 1] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // up
                        if (charArray[i - 1][j] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // down
                        if (charArray[i + 1][j] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // diag left up
                        if (charArray[i - 1][j - 1] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // diag left down
                        if (charArray[i + 1][j - 1] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // diag right up
                        if (charArray[i - 1][j + 1] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        // diag right down
                        if (charArray[i + 1][j + 1] == SEARCH_CHAR) {
                            paperFound++;
                        }
                        if (paperFound < 4) {
                            accessible++;
                            total++;
                            charArray[i][j] = '.';
                        }
                    }
                }
            }

        } while (accessible > 0);

        return total;
    }

    private List<String> paddingLines(int length) {
        List<String> p = new ArrayList<>(PADDING);
        for (int i = 0; i < PADDING; i++) {
            p.add(".".repeat(length + PADDING + PADDING));
        }
        return p;
    }
}
