package com.jcsanchez.hans.intents;

import com.jcsanchez.hans.model.LexRequest;
import com.jcsanchez.hans.model.LexResponse;

import static com.jcsanchez.hans.HansBot.delegate;

public class SearchGithubIntent extends Intent {

    public LexResponse processRequest(LexRequest request) {
        String source = request.getInvocationSource();

        if ("DialogCodeHook".equals(source)) {
            String searchTerm = request.getCurrentIntent().getSlots().get("SearchTerm");
            if (searchTerm == null) {
                return delegate(request.getSessionAttributes(), request.getCurrentIntent().getSlots());
            }
        }

        return null;
    }
}
