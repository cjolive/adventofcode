package uk.co.cjolive.adventofcode2024;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import uk.co.cjolive.Day;

public class Day6 extends Day {
    @Override
    public long task1(boolean isTest) {

        Map<Integer, String> puzzleMap = puzzleInputAsMap(isTest);

        Integer lineNumber = puzzleMap.entrySet().stream()
                .filter(e -> e.getValue().contains("^"))
                .findFirst()
                .get()
                .getKey();

        String startLineString = puzzleMap.get(lineNumber);
        Integer linePosition = startLineString.indexOf('^');
        boolean finished = false;
        Move nextMove = Move.UP;
        char nextPos;

        Set<Visited> visitedLocations = new HashSet<>();

        visitedLocations.add(new Visited(lineNumber, linePosition));
        while (!finished) {
            try {
                switch (nextMove) {
                    case UP -> {
                        lineNumber--;
                        nextPos = puzzleMap.get(lineNumber).charAt(linePosition);
                        if (turnRight(nextPos)) {
                            lineNumber++;
                            nextMove = Move.RIGHT;
                        } else {
                            visitedLocations.add(new Visited(lineNumber, linePosition));
                        }
                    }
                    case DOWN -> {
                        lineNumber++;
                        nextPos = puzzleMap.get(lineNumber).charAt(linePosition);
                        if (turnRight(nextPos)) {
                            lineNumber--;
                            nextMove = Move.LEFT;
                        } else {
                            visitedLocations.add(new Visited(lineNumber, linePosition));
                        }
                    }
                    case LEFT -> {
                        linePosition--;
                        nextPos = puzzleMap.get(lineNumber).charAt(linePosition);
                        if (turnRight(nextPos)) {
                            linePosition++;
                            nextMove = Move.UP;
                        } else {
                            visitedLocations.add(new Visited(lineNumber, linePosition));
                        }
                    }
                    case RIGHT -> {
                        linePosition++;
                        nextPos = puzzleMap.get(lineNumber).charAt(linePosition);
                        if (turnRight(nextPos)) {
                            linePosition--;
                            nextMove = Move.DOWN;
                        } else {
                            visitedLocations.add(new Visited(lineNumber, linePosition));
                        }
                    }
                }
            } catch (Exception e) {
                finished = true;
            }
        }

        return visitedLocations.size();
    }

    private boolean turnRight(char c) {
        return c == '#';
    }

    @Override
    public long task2(boolean isTest) {
        return 0;
    }

    enum Move {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    record Visited(Integer x, Integer y) {}
}
