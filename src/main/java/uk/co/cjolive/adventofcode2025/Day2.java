package uk.co.cjolive.adventofcode2025;

import uk.co.cjolive.Day;

public class Day2 extends Day {
    @Override
    public long task1(boolean isTest) {
        String[] list = puzzleInputStream(isTest).findFirst().get().split(",");

        long invalid = 0;
        for (String s : list) {
            String[] parts = s.split("-");

            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);

            for (long i = start; i <= end; i++) {
                String ss = String.valueOf(i);
                if (checkInvalid(ss)) {
                    invalid += i;
                }
            }
        }
        return invalid;
    }

    boolean checkInvalid(String s) {
        if (s.length() % 2 != 0) return false;

        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);
        if (firstHalf.equals(secondHalf)) return true;
        return false;
    }

    @Override
    public long task2(boolean isTest) {
        String[] list = puzzleInputStream(isTest).findFirst().get().split(",");

        long invalid = 0;
        for (String s : list) {
            String[] parts = s.split("-");

            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);

            for (long i = start; i <= end; i++) {
                String ss = String.valueOf(i);
                if (checkInvalidPartTwo(ss)) {
                    invalid += i;
                }
            }
        }
        return invalid;
    }

    boolean checkInvalidPartTwo(String s) {

        for (int i = 0; i <= s.length() / 2; i++) {
            String left = s.replace(s.substring(0, i), "");
            if (left.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
