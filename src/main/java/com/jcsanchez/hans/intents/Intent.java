package com.jcsanchez.hans.intents;

import com.jcsanchez.hans.model.LexRequest;
import com.jcsanchez.hans.model.LexResponse;

import java.util.Map;

public abstract class Intent {

    Map<String, String> slots;
    LexRequest request;

    public abstract LexResponse processRequest();

    public void setRequest(LexRequest request) {
        this.request = request;
    }

    public Intent withRequest(LexRequest request) {
        setRequest(request);
        return this;
    }
}
