package hu.godenyd.aoc2022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Day {

    private final String filesRoot = "src/files/";
    private BufferedReader taskReader = null;

    protected int dayNumber = 0;
    public String dayFileName = "";

    public Day() {
        try {
            openTaskFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void openTaskFile() throws FileNotFoundException {
        taskReader = new BufferedReader(new FileReader(new File(filesRoot + getClass().getSimpleName() + ".txt")));
    }

    protected String getRowFromTaskFile() {

        try {
            return taskReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public abstract void doTask();
}
