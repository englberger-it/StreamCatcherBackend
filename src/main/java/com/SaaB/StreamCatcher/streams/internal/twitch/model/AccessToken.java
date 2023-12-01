package com.SaaB.StreamCatcher.streams.internal.twitch.model;

import java.time.LocalDateTime;

/**
 * internal representation of an access token returned by the twitch api. Holding the time at which the token expires.
 *
 * @param token     the token to use for authentication
 * @param expiresAt the time at which the token expires
 */
public record AccessToken(String token, LocalDateTime expiresAt) {

    public static AccessToken fromAccessTokenResponse(AccessTokenResponse accessTokenResponse) {
        return new AccessToken(
                accessTokenResponse.accessToken(),
                LocalDateTime.now().plusSeconds(accessTokenResponse.expiresIn())
        );
    }

    /**
     * @return true if the token is expired
     */
    public boolean isExpired() {
        return expiresAt.isBefore(LocalDateTime.now());
    }
}
