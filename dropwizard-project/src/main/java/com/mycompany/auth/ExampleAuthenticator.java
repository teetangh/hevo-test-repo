package com.mycompany.auth;

import java.util.Optional;

import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class ExampleAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    // public Optional<User> authenticate(BasicCredentials credentials) throws
    // AuthenticationException {
    public Optional<User> authenticate(BasicCredentials credentials) {
        if ("secret".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername()));
        }
        return Optional.empty();
    }
}