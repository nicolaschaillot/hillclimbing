package com.nicolas.hillclimbing;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {

    private ArrayList<Quantity> quantities = new ArrayList<>();

    public Combination(ArrayList<Quantity> quantities) {
        this.quantities.addAll(quantities);
    }

    public Combination(Combination combination) {
        combination.quantities.stream().forEach(x -> quantities.add(x));
    }

    public int getResult() {

        int value1 = this.quantities.get(0).getValue();
        int value2 = this.quantities.get(1).getValue();

        return 50 + value1 + (value2 * 3);

    }

    public String getResultString() {
        String returnValue = String.format("50 + %d + ( %d x 3 ) =  %d",
                this.quantities.get(0).getValue(),
                this.quantities.get(1).getValue(),
                this.getResult());
        return returnValue;
    }

    public ArrayList<Quantity> getQuantities() {
        return quantities;
    }

    @Override
    public String toString() {
        return Arrays.toString(quantities.toArray());
    }
}
