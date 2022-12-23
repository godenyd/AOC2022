package hu.godenyd;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import hu.godenyd.aoc2022.Day;

public class DayTest extends Day {

    String dayFileName = "test.txt";

    public DayTest() throws FileNotFoundException {
        super();
    }

    @Test
    public void testDailyFileRead() {
        assertEquals("testing", getRowFromTaskFile());
    }

    @Override
    public void doTask() {
        // TODO Auto-generated method stub
        
    }
}
