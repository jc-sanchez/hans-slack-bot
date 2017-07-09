
package com.jcsanchez.hans.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CurrentIntent {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("slots")
    @Expose
    private Map<String, String> slots;

    @SerializedName("confirmationStatus")
    @Expose
    private String confirmationStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, String> slots) {
        this.slots = slots;
    }

    public String getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(String confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }

}
