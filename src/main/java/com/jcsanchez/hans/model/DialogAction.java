package com.jcsanchez.hans.model;

import com.amazonaws.services.lexruntime.model.ResponseCard;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;


public class DialogAction {

    @SerializedName("type")
    @Expose
    private DialogActionType type;

    @SerializedName("fulfillmentState")
    @Expose
    private FulfillmentState fulfillmentState;

    @SerializedName("message")
    @Expose
    private Message message;

    @SerializedName("responseCard")
    @Expose
    private ResponseCard responseCard;

    @SerializedName("intentName")
    @Expose
    private String intentName;

    @SerializedName("slotToElicit")
    @Expose
    private String slotToElicit;

    @SerializedName("slots")
    @Expose
    private Map<String, String> slots;

    public DialogActionType getType() {
        return type;
    }

    public void setType(DialogActionType type) {
        this.type = type;
    }

    public DialogAction withType(DialogActionType type) {
        setType(type);
        return this;
    }

    public FulfillmentState getFulfillmentState() {
        return fulfillmentState;
    }

    public void setFulfillmentState(FulfillmentState fulfillmentState) {
        this.fulfillmentState = fulfillmentState;
    }

    public DialogAction withFullfillmentState(FulfillmentState fullfillmentState) {
        setFulfillmentState(fullfillmentState);
        return this;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public DialogAction withMessage(Message message) {
        setMessage(message);
        return this;
    }

    public ResponseCard getResponseCard() {
        return responseCard;
    }

    public void setResponseCard(ResponseCard responseCard) {
        this.responseCard = responseCard;
    }

    public DialogAction withResponseCard(ResponseCard responseCard) {
        setResponseCard(responseCard);
        return this;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public DialogAction withIntentName(String intentName) {
        setIntentName(intentName);
        return this;
    }

    public String getSlotToElicit() {
        return slotToElicit;
    }

    public void setSlotToElicit(String slotToElicit) {
        this.slotToElicit = slotToElicit;
    }

    public DialogAction withSlotToElicit(String slotToElicit) {
        setSlotToElicit(slotToElicit);
        return this;
    }

    public Map<String, String> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, String> slots) {
        this.slots = slots;
    }

    public DialogAction withSlots(Map<String, String> slots) {
        setSlots(slots);
        return this;
    }
}
