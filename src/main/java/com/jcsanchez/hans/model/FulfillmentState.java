package com.jcsanchez.hans.model;

public enum FulfillmentState {

    Fulfilled("Fulfilled"),
    Failed("Failed");

    private String value;

    private FulfillmentState(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static FulfillmentState fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (FulfillmentState enumEntry : FulfillmentState.values()) {
            if (enumEntry.toString().equals(value)) {
                return enumEntry;
            }
        }

        throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
    }
}
