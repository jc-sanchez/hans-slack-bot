package com.jcsanchez.hans.intents;

import com.jcsanchez.hans.model.LexRequest;
import com.jcsanchez.hans.model.LexResponse;

public class SearchGithubIntent extends Intent {

    public LexResponse processRequest(LexRequest request) {
        System.out.println("Processing request inside SearchGithub");
        return null;
    }
}
