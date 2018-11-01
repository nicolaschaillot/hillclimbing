package com.nicolas.hillclimbing;

public class Quantity {

    private int value;
    private String unit;
    private int order;

    public Quantity(int value, String unit, int order) {
        this.value = value;
        this.unit = unit;
        this.order = order;
    }

    public Quantity(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", order=" + order +
                '}';
    }

    public void increase() {
        this.value++;
    }

    public void decrease() {
        this.value--;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
