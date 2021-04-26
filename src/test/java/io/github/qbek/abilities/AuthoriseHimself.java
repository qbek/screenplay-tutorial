package io.github.qbek.abilities;

import net.serenitybdd.screenplay.Ability;
import org.yecht.Data;

public class AuthoriseHimself implements Ability {

    private String email;
    private String password;

    public AuthoriseHimself(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("authorise himself using: %s / %s", email, password);
    }
}
