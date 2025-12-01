package uk.co.cjolive.adventofcode2024;

import uk.co.cjolive.Day;

public class Day7 extends Day {
    @Override
    public long task1(boolean isTest) {
        final long sum = 0;
        puzzleInputStream(isTest).forEach(s -> {
            //      sum += 1;
        });

        return sum;
    }

    private Long checkString(String s) {

        // 9 7 18 13
        //  *  *  *
        // 1  2  3

        // 3267: 81 40 27
        // ++

        long total;
        long[] numbers = new long[] {81, 40, 27};

        int maxChecks = 2 ^ (numbers.length - 1);

        int check = 1;

        // check % pos

        return 0L;
    }

    @Override
    public long task2(boolean isTest) {
        return 0;
    }
}
