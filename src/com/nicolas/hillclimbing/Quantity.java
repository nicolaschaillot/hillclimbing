package com.nicolas.hillclimbing;

import com.sun.deploy.util.StringUtils;

public class Quantity {

    private int value;
    private String unit;
    private int order;
    private String type;

    public Quantity(int value, String unit, int order, String type) {
        this.value = value;
        this.unit = unit;
        this.order = order;
        this.type = type;
    }

    public Quantity(int value, String type) {
        this.value = value;
        this.type = type;
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
        if (this.type == "A") {
            this.value = this.value + 5;
        } else {
            this.value++;
        }
    }

    public void decrease() {
        if (this.type == "A") {
            this.value = this.value - 5;
        } else {
            this.value--;
        }
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
