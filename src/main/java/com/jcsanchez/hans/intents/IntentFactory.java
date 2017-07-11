package com.jcsanchez.hans.intents;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class IntentFactory {

    private static final Map<String, Supplier<Intent>> intentMappings = new HashMap<>();
    static {
        intentMappings.put("SEARCHGITHUB", SearchGithubIntent::new);
    }

    public static Intent getIntent(String intentType) {
        Supplier<Intent> intent = intentMappings.get(intentType.toUpperCase());
        if (intent != null) {
            return intent.get();
        }

        throw new IllegalArgumentException("No such intent " + intentType);
    }
}
