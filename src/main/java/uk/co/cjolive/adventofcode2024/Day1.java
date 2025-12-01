package uk.co.cjolive.adventofcode2024;

import java.util.*;
import uk.co.cjolive.Day;

public class Day1 extends Day {

    @Override
    public long task1(boolean isTest) {
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        puzzleInputStream().forEach(string -> {
            String[] parts = string.split("   ");
            listOne.add(Integer.parseInt(parts[0]));
            listTwo.add(Integer.parseInt(parts[1]));
        });

        listOne.sort(Comparator.naturalOrder());
        listTwo.sort(Comparator.naturalOrder());

        int sum = 0;

        for (int i = 0; i < listOne.size(); i++) {
            sum += Math.abs(listOne.get(i) - listTwo.get(i));
        }

        return sum;
    }

    @Override
    public long task2(boolean isTest) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        puzzleInputStream().forEach(string -> {
            String[] parts = string.split("   ");
            map.put(Integer.parseInt(parts[0]), 0);
            listTwo.add(Integer.parseInt(parts[1]));
        });

        listTwo.stream().forEach(integer -> {
            map.computeIfPresent(integer, (k, v) -> v + 1);
        });

        return map.entrySet().stream()
                .map(e -> {
                    return e.getKey() * e.getValue();
                })
                .mapToInt(Integer::intValue)
                .sum();
    }
}
