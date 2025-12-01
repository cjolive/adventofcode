package uk.co.cjolive.adventofcode2024;

import java.util.Arrays;
import java.util.List;
import uk.co.cjolive.Day;

public class Day11 extends Day {

    @Override
    public long task1(boolean isTest) {
        List<Stone> startingStones = Arrays.stream(
                        puzzleInputStream(" ", isTest).findFirst().get())
                .map(s -> Long.parseLong(s))
                .map(l -> new Stone(l))
                .toList();

        for (int i = 0; i < 25; i++) {
            startingStones = startingStones.stream()
                    .map(stone -> stone.split())
                    .flatMap(List::stream)
                    .toList();
        }

        return startingStones.size();
    }

    @Override
    public long task2(boolean isTest) {
        List<Stone> startingStones = Arrays.stream(
                        puzzleInputStream(" ", isTest).findFirst().get())
                .map(s -> Long.parseLong(s))
                .map(l -> new Stone(l))
                .toList();

        for (int i = 0; i < 75; i++) {
            System.out.println("running: " + i + ", size: " + startingStones.size());
            startingStones = startingStones.stream()
                    .map(stone -> stone.split())
                    .flatMap(List::stream)
                    .toList();
        }

        return startingStones.size();
    }

    class Stone {

        long number;

        Stone(long number) {
            this.number = number;
        }

        public List<Stone> split() {
            if (number == 0L) {
                return List.of(new Stone(1));
            }

            String stoneString = String.valueOf(number);

            if (stoneString.length() % 2 == 0) {
                Long left = Long.parseLong(stoneString.substring(0, stoneString.length() / 2));
                Long right = Long.parseLong(stoneString.substring(stoneString.length() / 2));
                return List.of(new Stone(left), new Stone(right));
            }
            return List.of(new Stone(number * 2024));
        }
    }
}
