package uk.co.cjolive.adventofcode2024;

import java.util.ArrayList;
import java.util.List;
import uk.co.cjolive.Day;

public class Day4 extends Day {

    private static final int PADDING = 3;

    @Override
    public long task1(boolean isTest) {
        List<String> input = puzzleInputStream(isTest).toList();
        int stringLength = input.getFirst().length();
        List<String> padded = new ArrayList<>();
        padded.addAll(paddingLines(stringLength));
        padded.addAll(input.stream()
                .map(s -> {
                    return "..." + s + "...";
                })
                .toList());
        padded.addAll(paddingLines(stringLength));

        List<char[]> charList = padded.stream().map(s -> s.toCharArray()).toList();
        char[][] charArray = charList.toArray(new char[charList.size()][]);

        long xmasFound = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                if (charArray[i][j] == 'X') {
                    // right
                    if (charArray[i][j + 1] == 'M' && charArray[i][j + 2] == 'A' && charArray[i][j + 3] == 'S') {
                        xmasFound++;
                    }
                    // left
                    if (charArray[i][j - 1] == 'M' && charArray[i][j - 2] == 'A' && charArray[i][j - 3] == 'S') {
                        xmasFound++;
                    }
                    // up
                    if (charArray[i - 1][j] == 'M' && charArray[i - 2][j] == 'A' && charArray[i - 3][j] == 'S') {
                        xmasFound++;
                    }
                    // down
                    if (charArray[i + 1][j] == 'M' && charArray[i + 2][j] == 'A' && charArray[i + 3][j] == 'S') {
                        xmasFound++;
                    }
                    // diag left up
                    if (charArray[i - 1][j - 1] == 'M'
                            && charArray[i - 2][j - 2] == 'A'
                            && charArray[i - 3][j - 3] == 'S') {
                        xmasFound++;
                    }
                    // diag left down
                    if (charArray[i + 1][j - 1] == 'M'
                            && charArray[i + 2][j - 2] == 'A'
                            && charArray[i + 3][j - 3] == 'S') {
                        xmasFound++;
                    }
                    // diag right up
                    if (charArray[i - 1][j + 1] == 'M'
                            && charArray[i - 2][j + 2] == 'A'
                            && charArray[i - 3][j + 3] == 'S') {
                        xmasFound++;
                    }
                    // diag right down
                    if (charArray[i + 1][j + 1] == 'M'
                            && charArray[i + 2][j + 2] == 'A'
                            && charArray[i + 3][j + 3] == 'S') {
                        xmasFound++;
                    }
                }
            }
        }
        return xmasFound;
    }

    @Override
    public long task2(boolean isTest) {
        return 0;
    }

    private List<String> paddingLines(int length) {
        List<String> p = new ArrayList<>(PADDING);
        for (int i = 0; i < PADDING; i++) {
            p.add(".".repeat(length + PADDING + PADDING));
        }
        return p;
    }
}
