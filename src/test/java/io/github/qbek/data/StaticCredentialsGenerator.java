package io.github.qbek.data;

import io.github.qbek.abilities.AuthoriseHimself;

public class StaticCredentialsGenerator implements CredentialsGenerator {
    @Override
    public AuthoriseHimself getAccount() {
        return new AuthoriseHimself("gbinxeqerpnywwysux@awdrt.org", "ti4FCvBL39i7mMq");
    }
}
