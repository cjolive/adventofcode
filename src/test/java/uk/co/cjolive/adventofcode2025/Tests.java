package uk.co.cjolive.adventofcode2025;

import org.junit.jupiter.api.Test;
import uk.co.cjolive.Day;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    public void testDay1() {
        Day day = new Day1();
        assertThat(day.task1(true)).isEqualTo(3);
        assertThat(day.task1()).isEqualTo(1132);
        assertThat(day.task2(true)).isEqualTo(6);
        assertThat(day.task2()).isEqualTo(6623);
    }


}
