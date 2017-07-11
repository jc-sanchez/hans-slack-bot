package com.jcsanchez.hans.intents;

import com.jcsanchez.hans.model.LexRequest;
import com.jcsanchez.hans.model.LexResponse;

import java.util.Map;

public abstract class Intent {

    Map<String, String> slots;

    public abstract LexResponse processRequest(LexRequest request);
}
