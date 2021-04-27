package io.github.qbek.data;

import io.github.qbek.abilities.AuthoriseHimself;

public class StaticCredentialsGenerator implements CredentialsGenerator {
    @Override
    public AuthoriseHimself getAccount() {
        return new AuthoriseHimself("gbinxeqerpnywwysux@awdrt.org", "ti4FCvBL39i7mMq", "Bearer d469ce54eca3a7ca5b6b5e7d4c8d51ced8d4c7b1");
    }
}
