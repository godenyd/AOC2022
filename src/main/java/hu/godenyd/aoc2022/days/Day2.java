package hu.godenyd.aoc2022.days;

import java.util.ArrayList;
import java.util.List;

import hu.godenyd.aoc2022.Day;

public class Day2 extends Day {

    @Override
    public void doTask() {
        int sum = 0;
        int secondSum = 0;

        String line = "";

        List<String> lines = new ArrayList<String>();

        while (line != null) {
            line = getRowFromTaskFile();

            if (line == null) {
                break;
            }

            String left = line.substring(0, line.length() / 2);
            String right = line.substring(line.length() / 2, line.length());

            sum += getValueFromLine(left, right);

            lines.add(line);

            if (lines.size() == 3) {
                secondSum += getValueFrom3Lines(lines.get(0), lines.get(1), lines.get(2));
                lines.clear();
            }
        }

        System.out.println(sum);
        System.out.println(secondSum);
    }

    // I hate myself...
    private int getValueFrom3Lines(String line1, String line2, String line3) {

        for (int i = 0; i < line1.length(); i++) {
            for (int j = 0; j < line2.length(); j++) {
                for (int k = 0; k < line3.length(); k++) {
                    if (line1.charAt(i) == line2.charAt(j) && line2.charAt(j) == line3.charAt(k)) {
                        return calculateCharValue(line1.charAt(i));
                    }
                }
            }
        }

        return 0;
    }

    private int getValueFromLine(String left, String right) {
        for (int i = 0; i < left.length(); i++) {

            char c = left.charAt(i);
            if (right.contains(String.valueOf(c))) {
                return calculateCharValue(c);
            }
        }

        return 0;
    }

    public int calculateCharValue(char s) {

        int offset = Character.isLowerCase(s) ? 1 : 27;

        if (Character.isLowerCase(s)) {
            return s - 'a' + offset;
        } else {
            return s - 'A' + offset;
        }
    }
}
