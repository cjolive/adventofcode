package uk.co.cjolive.adventofcode2025;

import java.util.List;
import uk.co.cjolive.Day;

public class Day3 extends Day {
    @Override
    public long task1(boolean isTest) {
        List<String> stringList = puzzleInputStream(isTest).toList();

        long sum = 0;

        for (String s : stringList) {
            char[] chars = s.toCharArray();
            int highestFirstChar = 0;
            int highestSecondChar = 0;
            int highestFirstCharPos = 0;
            for (int i = 0; i < chars.length - 1; i++) {
                int num = chars[i] - '0';
                if (num > highestFirstChar) {
                    highestFirstChar = num;
                    highestFirstCharPos = i;
                }
            }
            for (int i = chars.length - 1; i > highestFirstCharPos; i--) {
                int num = chars[i] - '0';
                if (num > highestSecondChar) {
                    highestSecondChar = num;
                }
            }
            int number = Integer.parseInt("" + highestFirstChar + highestSecondChar);
            sum += number;
        }

        return sum;
    }

    @Override
    public long task2(boolean isTest) {
        List<String> stringList = puzzleInputStream(isTest).toList();

        final int numBatteries = 12;

        long sum = 0;

        for (String s : stringList) {
            StringBuilder sb = new StringBuilder();
            int lastFoundPos = 0;
            String searchString = s.substring(lastFoundPos);

            for (int i = 0; i < numBatteries; i++) {

                char[] chars = searchString.toCharArray();

                int highestFirstChar = 0;
                int searchUntil = searchString.length() - (numBatteries - (i + 1));

                for (int j = 0; j < searchUntil; j++) {
                    int num = chars[j] - '0';
                    if (num > highestFirstChar) {
                        highestFirstChar = num;
                        lastFoundPos = j;
                    }
                }
                sb.append(highestFirstChar);
                searchString = searchString.substring((lastFoundPos + 1));
            }
            sum += Long.parseLong(sb.toString());
        }

        return sum;
    }
}
