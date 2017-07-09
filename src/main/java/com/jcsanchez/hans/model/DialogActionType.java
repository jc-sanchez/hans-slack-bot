package com.jcsanchez.hans.model;

public enum DialogActionType {

    ElicitIntent("ElicitIntent"),
    ElicitSlot("ElicitSlot"),
    ConfirmIntent("ConfirmIntent"),
    Delegate("Delegate"),
    Close("Close");

    private String value;

    private DialogActionType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static DialogActionType fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (DialogActionType enumEntry : DialogActionType.values()) {
            if (enumEntry.toString().equals(value)) {
                return enumEntry;
            }
        }

        throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
    }
}
