package io.github.qbek.facts;

import net.serenitybdd.screenplay.facts.Fact;

public class Facts {

    public static Fact projectCreated(String name) {
        return new HasProjectCreated(name);
    }

    public static Fact account() {
        return new HasAccount();
    }
}
