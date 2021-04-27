package io.github.qbek.abilities;

import net.serenitybdd.screenplay.Ability;

public class AuthoriseHimself implements Ability {

    private String email;
    private String password;
    private String token;

    public AuthoriseHimself(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
