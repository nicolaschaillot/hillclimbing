package com.nicolas.hillclimbing;

public class HillClimbing {

    public static final int MAX_ITERATION = 50;
    public static final int TARGET = 168;
    public static final int TARGET_ERROR = 10; // error percentage


    public Combination findBestCombination(Combination currentCombination) {

        Combination adjacentCombination;
        String compareCombinations = null;
        int iterToMaximalCount = 0;

        while (iterToMaximalCount < MAX_ITERATION) {
            adjacentCombination = obtainAdjacentCombination(new Combination(currentCombination));

            int currentGap = Math.abs(currentCombination.getResult() - TARGET);
            int adjacentGap = Math.abs(adjacentCombination.getResult() - TARGET);

            System.out.println("  | error => " + (Math.abs(adjacentGap - TARGET) * 100 / TARGET));
            if ( (Math.abs(currentGap - TARGET) * 100 / TARGET) < TARGET_ERROR ) {
                break;
            }

            if ( adjacentGap < currentGap ) {
                compareCombinations = "<= (proceed)";
                iterToMaximalCount = 0;
                currentCombination = new Combination(adjacentCombination);
            } else {
                compareCombinations = "> (stay) - iteration # " + iterToMaximalCount++;
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

        int y = (int) Math.round( Math.random() );
        if (y == 1) {
            quantity.increase();
        } else {
            quantity.decrease();
        }

        combination.getQuantities().set(x, quantity);

        return combination;
    }

}
