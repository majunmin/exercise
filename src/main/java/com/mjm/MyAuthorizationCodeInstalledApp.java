package com.mjm;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;

import java.io.IOException;

public class MyAuthorizationCodeInstalledApp extends AuthorizationCodeInstalledApp {

    private static final Long EXPIRE_MIN = 60L;

    public MyAuthorizationCodeInstalledApp(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
        super(flow, receiver);
    }


    public Credential authorizeAfter(String userId) throws IOException {
        Credential credential = this.getFlow().loadCredential(userId);
        if (credential == null) {
            return null;
        }
        if (credential.getRefreshToken() != null) {
            return credential;
        }

        if (credential.getExpiresInSeconds() == null) {
            return credential;
        }

        if (credential.getExpiresInSeconds() > EXPIRE_MIN) {
            return credential;
        }
        return null;
    }

    @Override
    public Credential authorize(String userId) throws IOException {
        Credential credential;
        try {
            credential = this.getFlow().loadCredential(userId);
            if (credential != null && (credential.getRefreshToken() != null || credential.getExpiresInSeconds() == null || credential.getExpiresInSeconds() > 60L)) {
                return credential;
            }

            String redirectUri = this.getReceiver().getRedirectUri();
            AuthorizationCodeRequestUrl authorizationUrl = this.getFlow().newAuthorizationUrl().setRedirectUri(redirectUri);
            super.onAuthorization(authorizationUrl);
            String code = this.getReceiver().waitForCode();
            TokenResponse response = this.getFlow().newTokenRequest(code).setRedirectUri(redirectUri).execute();
            credential = this.getFlow().createAndStoreCredential(response, userId);
        } finally {
            this.getReceiver().stop();
        }

        return credential;
    }
}