package hu.godenyd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.godenyd.aoc2022.days.Day2;

public class Day2Test extends Day2 {

    @Test
    public void testCharValueCalculation() {
        assertEquals(2, calculateCharValue('b'));
        assertEquals(1, calculateCharValue('a'));
        assertEquals(27, calculateCharValue('A'));
        assertEquals(28, calculateCharValue('B'));
    }

}
