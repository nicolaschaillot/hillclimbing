package com.nicolas.hillclimbing;

public class HillClimbing {

    public static final int MAX_ITERATION = 100;
    public static final int TARGET = 168;
    public static final int TARGET_MIN = 163;
    public static final int TARGET_MAX = 165;
    public static final int TARGET_ERROR = 1; // 1% error percentage


    public Combination findBestCombination(Combination currentCombination) {

        Combination adjacentCombination;
        String compareCombinations = null;
        int iterToMaximalCount = 0;

        while (iterToMaximalCount < MAX_ITERATION) {
            adjacentCombination = obtainAdjacentCombination(new Combination(currentCombination));

//            int currentGap = Math.abs(currentCombination.getResult() - TARGET);
//            int adjacentGap = Math.abs(adjacentCombination.getResult() - TARGET);
//
//            System.out.println("currentGap = " + currentGap);
//            System.out.println("adjacentGap = " + adjacentGap);
//
//            System.out.println("  | error => " + currentGap * 100 / TARGET);

//            if (adjacentCombination.getResult() <= 0 ||
//            adjacentCombination.getResult() < TARGET_MIN ) {
//
//            }

//            if ( adjacentCombination.getResult() > TARGET_MIN &&
//                    adjacentCombination.getResult() < TARGET_MAX ) {
//                break;
//            }

            if ( adjacentCombination.getResult() <= TARGET_MIN ||
                    adjacentCombination.getResult() >= TARGET_MAX ) {
                currentCombination = new Combination(adjacentCombination);
                compareCombinations = currentCombination.getResultString() + " <= (proceed) - iteration # " + iterToMaximalCount++;
            } else {
                compareCombinations = currentCombination.getResultString() + " > (stay) - iteration # " + iterToMaximalCount++;
                break;
            }
            System.out.println("  |" + compareCombinations);
            System.out.println(currentCombination + "  |" + currentCombination.getResultString());
        }

        if (iterToMaximalCount == MAX_ITERATION) {
            System.out.println("  | potential maximum reached !!!");
        } else {
            System.out.println("  |" + compareCombinations);
        }

        return currentCombination;
    }

    private Combination obtainAdjacentCombination(Combination combination) {

        int x = (int) Math.round( Math.random() );

        Quantity quantity = combination.getQuantities().get(x);
//
//        int y = (int) Math.round( Math.random() );
//        if (y == 1 || quantity.getValue() == 0) {
//            quantity.increase();
//        } else {
//            quantity.decrease();
//        }

        if (combination.getResult() >= TARGET_MAX && quantity.getValue() > 1) {
            quantity.decrease();
        } else {
            quantity.increase();
        }

        combination.getQuantities().set(x, quantity);

        return combination;
    }

}
