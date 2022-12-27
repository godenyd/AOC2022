package hu.godenyd.aoc2022.days;

import hu.godenyd.aoc2022.Day;

public class Day3 extends Day {

    @Override
    public void doTask() {
        int fullOverlapCount = 0;
        int overlapCount = 0;
        String line = "";

        while (line != null) {
            line = getRowFromTaskFile();

            if (line == null) {
                break;
            }

            String[] intervals = line.split(",");

            String[] elf1 = intervals[0].split("-");
            String[] elf2 = intervals[1].split("-");

            int leftx1 = Integer.parseInt(elf1[0]);
            int leftx2 = Integer.parseInt(elf1[1]);
            int rightx1 = Integer.parseInt(elf2[0]);
            int rightx2 = Integer.parseInt(elf2[1]);

            if (leftx1 >= rightx1 &&
                    leftx2 <= rightx2 ||
                    leftx1 <= rightx1 &&
                            leftx2 >= rightx2) {
                fullOverlapCount++;
            }

            if (leftx1 <= rightx1 && leftx1 <= rightx2 && leftx2 >= rightx1 && leftx2 <= rightx2 ||
                    leftx1 >= rightx1 && leftx1 <= rightx2 && leftx2 >= rightx1 && leftx2 >= rightx2 ||
                    (leftx1 >= rightx1 &&
                            leftx2 <= rightx2 ||
                            leftx1 <= rightx1 &&
                                    leftx2 >= rightx2)) {
                overlapCount++;
            }

        }
        System.out.println(fullOverlapCount);
        System.out.println(overlapCount);
    }

}
