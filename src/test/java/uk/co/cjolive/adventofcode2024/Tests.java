package uk.co.cjolive.adventofcode2024;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uk.co.cjolive.Day;

public class Tests {

    @Test
    public void testDay1() {
        Day day = new Day1();
        assertEquals(2769675, day.task1(false));
        assertEquals(24643097, day.task2(false));
    }

    @Test
    public void testDay2() {
        Day day = new Day2();
        assertEquals(2, day.task1(true));
        assertEquals(510, day.task1());
        assertEquals(4, day.task2(true));
        assertEquals(553, day.task2());
    }

    @Test
    public void testDay3() {
        Day day = new Day3();
        assertEquals(182619815, day.task1());
        assertEquals(80747545, day.task2());
    }

    @Test
    public void testDay4() {
        Day day = new Day4();
        assertEquals(2464, day.task1());
    }

    @Test
    public void testDay5() {
        Day day = new Day5();
        assertEquals(4959, day.task1());
        assertEquals(4655, day.task2());
    }

    @Test
    public void testDay6() {
        Day day = new Day6();
        assertEquals(41, day.task1(true));
        assertEquals(4696, day.task1());
    }

    @Test
    public void testDay9() {
        Day day = new Day9();
        assertEquals(41, day.task1());
    }

    @Test
    public void testDay11() {
        Day day = new Day11();
        assertEquals(55312, day.task1(true));
        assertEquals(182081, day.task1());
        assertEquals(182081, day.task2());
    }
}
