package hu.godenyd.aoc2022.days;

import java.util.SortedSet;
import java.util.TreeSet;

import hu.godenyd.aoc2022.Day;

public class Day0 extends Day {

    public Day0() {
        super();
    }

    @Override
    public void doTask() {

        int currentCalories = 0;

        String line = "";

        SortedSet<Integer> calories = new TreeSet<Integer>();

        while (line != null) {
            line = getRowFromTaskFile();

            if (line == null) {
                break;
            }

            if (line.length() == 0) {
                if (calories.size() < 3) {
                    calories.add(currentCalories);
                } else if (Integer.compare(currentCalories, calories.first()) > 0) {
                    calories.remove(calories.first());
                    calories.add(currentCalories);
                }

                currentCalories = 0;
                continue;
            } else {

                currentCalories += Integer.parseInt(line);
            }
        }

        System.out.println("Most calories carried: " + calories.last());
        System.out.println(calories.stream().mapToInt(Integer::intValue).sum());
    }
}