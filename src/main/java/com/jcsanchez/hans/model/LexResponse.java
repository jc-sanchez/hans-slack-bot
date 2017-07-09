package com.jcsanchez.hans.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class LexResponse {

    @SerializedName("sessionAttributes")
    @Expose
    Map<String, String> sessionAttributes;

    @SerializedName("dialogAction")
    @Expose
    DialogAction dialogAction;

    public Map<String, String> getSessionAttributes() {
        return sessionAttributes;
    }

    public void setSessionAttributes(Map<String, String> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }

    public LexResponse withSessionAttributes(Map<String, String> sessionAttributes) {
        setSessionAttributes(sessionAttributes);
        return this;
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }

    public void setDialogAction(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    public LexResponse withDialogAction(DialogAction dialogAction) {
        setDialogAction(dialogAction);
        return this;
    }
}
