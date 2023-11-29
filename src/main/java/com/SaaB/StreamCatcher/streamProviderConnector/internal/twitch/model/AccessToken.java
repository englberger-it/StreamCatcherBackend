package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

import java.time.LocalDateTime;

public record AccessToken(String token, LocalDateTime expiresAt) {

    public static AccessToken fromAccessTokenResponse(AccessTokenResponse accessTokenResponse) {
        return new AccessToken(
                accessTokenResponse.accessToken(),
                LocalDateTime.now().plusSeconds(accessTokenResponse.expiresIn())
        );
    }

    public boolean isExpired() {
        return expiresAt.isBefore(LocalDateTime.now());
    }
}
