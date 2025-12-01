package uk.co.cjolive.adventofcode2024;

import uk.co.cjolive.Day;

public class Day2 extends Day {
    @Override
    public long task1(boolean isTest) {
        return puzzleInputStream(" ", isTest).filter(this::checkLine).count();
    }

    private boolean checkLine(String[] line) {
        int previous = Integer.parseInt(line[0]);
        boolean increasing = previous < Integer.parseInt(line[1]);
        for (int i = 1; i < line.length; i++) {
            int current = Integer.parseInt(line[i]);
            if (current == previous) return false;

            if (current > previous && !increasing) return false;

            if (current < previous && increasing) return false;

            if (Math.abs(current - previous) > 3) return false;

            previous = current;
        }

        return true;
    }

    @Override
    public long task2(boolean isTest) {
        return puzzleInputStream(" ", isTest).filter(this::checkLineV2).count();
    }

    private boolean checkLineV2(String[] line) {
        if (checkLine(line)) return true;
        // check variations with one element removed
        String[] newline = new String[line.length - 1];
        int insertPos = 0;
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (i == j) continue;
                newline[insertPos] = line[j];
                insertPos++;
            }
            if (checkLine(newline)) return true;
            else {
                insertPos = 0;
            }
        }
        return false;
    }
}
