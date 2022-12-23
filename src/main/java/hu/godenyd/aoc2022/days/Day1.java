package hu.godenyd.aoc2022.days;

import hu.godenyd.aoc2022.Day;

public class Day1 extends Day {

    /*
     * X, A: Rock
     * Y, B: Paper
     * Z, C: Scissors
     */
    @Override
    public void doTask() {
        int score = 0;
        int plannedScore = 0;

        String line = "";

        while (line != null) {
            line = getRowFromTaskFile();

            if (line == null) {
                break;
            }

            String[] combo = line.split(" ");

            Gesture left = getGesture(combo[0]);
            Gesture right = getGesture(combo[1]);

            if (right.beats(left)) {    // we beat them
                score += 6;
            } else if (right.getScore() == left.getScore()) {   // we do the same
                score += 3;
            }
            score += right.getScore();

            String plan = combo[1];

            switch (plan) {
                case "X": // lose
                    plannedScore += left.beats().getScore();
                    break;
                case "Y": // draw
                    plannedScore += 3;
                    plannedScore += left.getScore();
                    break;
                case "Z": // win
                    plannedScore += 6;
                    plannedScore += left.beatenBy().getScore();
                    break;
            }


        }

        System.out.println(score);
        System.out.println(plannedScore);
    }

    private Gesture getGesture(String letter) {

        switch (letter) {
            case "X":
            case "A":
                return new Rock();
            case "Y":
            case "B":
                return new Paper();
            case "Z":
            case "C":
                return new Scissors();
            default:
                return null;
        }
    }

    private abstract class Gesture {
        public abstract boolean beats(Gesture other);

        public abstract Gesture beats();

        public abstract int getScore();

        public abstract Gesture beatenBy();
    }
    
    private class Rock extends Gesture {

        @Override
        public boolean beats(Gesture other) {
            return other instanceof Scissors ? true : false;
        }

        @Override
        public int getScore() {
            return 1;
        }

        @Override
        public Gesture beatenBy() {
            return new Paper();
        }

        @Override
        public Gesture beats() {
            return new Scissors();
        }
    }

    private class Paper extends Gesture {
        
        @Override
        public boolean beats(Gesture other) {
            return other instanceof Rock ? true : false;
        }

        @Override
        public int getScore() {
            return 2;
        }

        @Override
        public Gesture beatenBy() {
            return new Scissors();
        }

        @Override
        public Gesture beats() {
            return new Rock();
        }
    }

    private class Scissors extends Gesture {

        @Override
        public boolean beats(Gesture other) {
            return other instanceof Paper ? true : false;
        }

        @Override
        public int getScore() {
            return 3;
        }

        @Override
        public Gesture beatenBy() {
            return new Rock();
        }

        @Override
        public Gesture beats() {
            return new Paper();
        }
    }
}
