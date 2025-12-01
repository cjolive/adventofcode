package uk.co.cjolive.adventofcode2024;

import java.util.*;
import uk.co.cjolive.Day;

public class Day5 extends Day {

    Map<Integer, List<Integer>> ruleMap = new HashMap<>();

    @Override
    public long task1(boolean isTest) {

        puzzleInputStream(isTest).filter(s -> s.contains("|")).forEach(rule -> {
            String[] parts = rule.split("\\|");
            Integer first = Integer.parseInt(parts[0]);
            Integer second = Integer.parseInt(parts[1]);
            ruleMap.computeIfAbsent(first, k -> new ArrayList<>()).add(second);
        });

        List<String> updates =
                puzzleInputStream(isTest).filter(s -> s.contains(",")).toList();

        long sum = 0;
        for (String update : updates) {
            sum += valid(update);
        }

        return sum;
    }

    private int valid(String update) {
        String[] numbers = update.split(",");
        for (int i = 1; i < numbers.length; i++) {
            Integer num = Integer.parseInt(numbers[i]);
            List<Integer> mustNotBeBefore = ruleMap.get(num);
            for (int j = 0; j < i; j++) {
                if (mustNotBeBefore == null) continue;
                if (mustNotBeBefore.contains(Integer.parseInt(numbers[j]))) {
                    return 0;
                }
            }
        }
        int mid = numbers.length / 2;
        return Integer.parseInt(numbers[mid]);
    }

    @Override
    public long task2(boolean isTest) {
        puzzleInputStream(isTest).filter(s -> s.contains("|")).forEach(rule -> {
            String[] parts = rule.split("\\|");
            Integer first = Integer.parseInt(parts[0]);
            Integer second = Integer.parseInt(parts[1]);
            ruleMap.computeIfAbsent(first, k -> new ArrayList<>()).add(second);
        });

        List<String> updates = puzzleInputStream(isTest)
                .filter(s -> s.contains(","))
                .filter(this::invalid)
                .toList();

        long sum = 0;
        for (String update : updates) {
            sum += validResorted(update);
        }

        return sum;
    }

    private boolean invalid(String update) {
        String[] numbers = update.split(",");
        boolean valid = true;
        for (int i = 1; i < numbers.length; i++) {
            Integer num = Integer.parseInt(numbers[i]);
            List<Integer> mustNotBeBefore = ruleMap.get(num);
            for (int j = 0; j < i; j++) {
                if (mustNotBeBefore == null) continue;
                if (mustNotBeBefore.contains(Integer.parseInt(numbers[j]))) {
                    return true;
                }
            }
        }
        return false;
    }

    private int validResorted(String update) {
        String[] numbers = update.split(",");

        String[] sortedNumbers = Arrays.stream(numbers)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        Integer num = Integer.parseInt(o1);
                        List<Integer> mustNotBeBefore = ruleMap.get(num);
                        if (mustNotBeBefore.contains(Integer.parseInt(o2))) {
                            return 1;
                        }
                        return -1;
                    }
                })
                .toArray(String[]::new);

        int mid = sortedNumbers.length / 2;
        return Integer.parseInt(sortedNumbers[mid]);
    }
}
