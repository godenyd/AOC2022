package hu.godenyd.aoc2022.days;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import hu.godenyd.aoc2022.Day;

public class Day4 extends Day {

    @Override
    public void doTask() {
        List<Deque<Character>> stacks = new LinkedList<Deque<Character>>();

        for (int i = 0; i < 9; i++) {
            stacks.add(new LinkedList<Character>());
        }

        String line = "";
        final int firstCratePosition = 1;
        final int crateDistance = 4;

        int currentCratePos = firstCratePosition;

        for (int i = 0; i < 8; i++) {
            line = getRowFromTaskFile();

            for (int j = 0; j < 9; j++) {

                char crate = line.charAt(currentCratePos);

                if (crate != ' ') {
                    stacks.get(j).addLast(crate);
                }

                currentCratePos += crateDistance;
            }
            currentCratePos = firstCratePosition;
        }

        // skip 2 lines
        getRowFromTaskFile();
        getRowFromTaskFile();

        System.out.println("starting stacks:");
        printStacks(stacks);

        while (line != null) {
            line = getRowFromTaskFile();

            if (line == null || line.length() == 0) {
                break;
            }

            System.out.println("command: " + line);

            String[] commandPieces = line.split(" ");

            int count = Integer.parseInt(commandPieces[1]);
            int from = Integer.parseInt(commandPieces[3]);
            int to = Integer.parseInt(commandPieces[5]);

            Deque<Character> fromStack = stacks.get(from - 1);
            Deque<Character> toStack = stacks.get(to - 1);

            for (int i = 0; i < count; i++) {
                toStack.push(fromStack.pop());
            }

            // Deque<Character> moved = new LinkedList<>();

            // for (int i = 0; i < count; i++) {
            //     moved.push(fromStack.pop());
            // }

            // System.out.println("moved:");
            // for (int i = 0; i < moved.size(); i++) {
            //     System.out.println("[" + ((LinkedList)moved).get(moved.size() - 1- i) + "]");
            // }

            // for (int i = 0; i < count; i++) {
            //     toStack.push(moved.pop());
            // }            
        }

        printStacks(stacks);

        // String topRow = "";
        // for (int i = 0; i < stacks.size(); i++) {
        //     topRow = topRow.concat(String.valueOf(stacks.get(i).pop()));
        // }

        // System.out.println(topRow);

    }

    private void printStacks(List<Deque<Character>> stacks) {
        int maxSize = 
            stacks.stream()
            .mapToInt(Deque::size)
            .max()
            .getAsInt();

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < stacks.size(); j++) {

                Deque<Character> stack = stacks.get(j);
                int emptySlots = maxSize - stack.size();

                if (stack.size() >= maxSize - i) {
                    System.out.print("[" + ((LinkedList)stack).get(i - emptySlots) + "]");
                } else {
                    System.out.print("   ");
                }

                System.out.print(" ");
            }

            System.out.print("\n");
        }

        for (int i = 0; i < stacks.size(); i++) {
            System.out.print(" " + (i + 1) + "  ");
        }
        System.out.print("\n");
    }
}
