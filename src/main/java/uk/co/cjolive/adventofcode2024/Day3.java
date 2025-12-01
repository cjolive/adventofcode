package uk.co.cjolive.adventofcode2024;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import uk.co.cjolive.Day;

public class Day3 extends Day {
    @Override
    public long task1(boolean isTest) {
        String input = puzzleInputStream().collect(Collectors.joining());
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);
        long sum = 0;
        while (matcher.find()) {
            Long one = Long.parseLong(matcher.group(1));
            Long two = Long.parseLong(matcher.group(2));
            sum += (one * two);
        }

        return sum;
    }

    @Override
    public long task2(boolean isTest) {
        String input = puzzleInputStream().collect(Collectors.joining());
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|don't\\(\\)|do\\(\\)");
        Matcher matcher = pattern.matcher(input);
        boolean enabled = true;
        long sum = 0;
        while (matcher.find()) {
            String match = matcher.group();
            if (match.startsWith("mul")) {
                Long one = Long.parseLong(matcher.group(1));
                Long two = Long.parseLong(matcher.group(2));
                if (enabled) sum += (one * two);
            } else if (match.startsWith("don")) {
                enabled = false;
            } else {
                enabled = true;
            }
        }

        return sum;
    }
}
