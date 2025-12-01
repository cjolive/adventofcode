package uk.co.cjolive.adventofcode2025;

import java.util.List;

public class Day1 extends Year2025 {

    @Override
    public long task1(boolean isTest) {
        final int START_POS = 50;
        final int NUM_DIALS = 100;

        int currentPos = START_POS;
        int numberOfZeros = 0;

        List<String> stringList = puzzleInputStream(isTest).toList();

        for (String string : stringList) {
            char direction = string.charAt(0);
            int amount = Integer.parseInt(string.substring(1));

            if ('L' == direction) {
                currentPos = modularSubtraction(currentPos, amount, NUM_DIALS);
            } else {
                currentPos = modularAdd(currentPos, amount, NUM_DIALS);
            }
            if (currentPos == 0) numberOfZeros++;
        }

        return numberOfZeros;
    }

    @Override
    public long task2(boolean isTest) {
        final int START_POS = 50;
        final int NUM_DIALS = 100;

        int currentPos = START_POS;
        int numberOfZeros = 0;

        List<String> stringList = puzzleInputStream(isTest).toList();

        for (String string : stringList) {
            char direction = string.charAt(0);
            int parsedAmount = Integer.parseInt(string.substring(1));
            do {
                int amount = parsedAmount > NUM_DIALS ? NUM_DIALS : parsedAmount;
                int previousPos = currentPos;
                if ('L' == direction) {
                    currentPos = modularSubtraction(currentPos, amount, NUM_DIALS);
                    if (previousPos != 0 && previousPos - amount < 0) numberOfZeros++;
                } else {
                    currentPos = modularAdd(currentPos, amount, NUM_DIALS);
                    if (previousPos != 0 && previousPos + amount > NUM_DIALS) numberOfZeros++;
                }
                if (currentPos == 0) numberOfZeros++;
                parsedAmount -= NUM_DIALS;
            } while (parsedAmount > 0);
        }
        return numberOfZeros;
    }

    int modularAdd(int a, int b, int mod) {
        return (a + b) % mod;
    }

    int modularSubtraction(int a, int b, int mod) {
        return (a - b + mod) % mod;
    }

}
