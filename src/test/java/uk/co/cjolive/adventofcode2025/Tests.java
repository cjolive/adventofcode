package uk.co.cjolive.adventofcode2025;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uk.co.cjolive.Day;

public class Tests {

    @Test
    public void testDay1() {
        Day day = new Day1();
        assertThat(day.task1(true)).isEqualTo(3);
        assertThat(day.task1()).isEqualTo(1132);
        assertThat(day.task2(true)).isEqualTo(6);
        assertThat(day.task2()).isEqualTo(6623);
    }

    @Test
    public void testDay2() {
        Day day = new Day2();
        assertThat(day.task1(true)).isEqualTo(1227775554);
        assertThat(day.task1()).isEqualTo(29940924880L);
        assertThat(day.task2(true)).isEqualTo(4174379265L);
        assertThat(day.task2()).isEqualTo(48631958998L);
    }
}
