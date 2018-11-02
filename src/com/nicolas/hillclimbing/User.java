package com.nicolas.hillclimbing;

import java.util.ArrayList;
import java.util.Arrays;

public class User {

    private ArrayList<Quantity> initialQuantities = new ArrayList<>(Arrays.asList(
            new Quantity(0, "A"),
            new Quantity(0, "B")
    ));

    public static void main(String[] args) {

        User user = new User();
        Combination combination = new Combination(user.initialQuantities);

        System.out.println(combination + "  | " + combination.getResultString());

        new HillClimbing().findBestCombination(combination);

    }

}
