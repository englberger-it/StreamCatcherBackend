package com.SaaB.StreamCatcher.streams.internal.twitch.model;

/**
 * Represents an access token returned by the twitch api. see <a href="https://dev.twitch.tv/docs/authentication/getting-tokens-oauth#oauth-client-credentials-flow"/>
 *
 * @param accessToken the token to use for authentication
 * @param expiresIn   the number of seconds until the token expires
 * @param tokenType   the type of the token
 */
public record AccessTokenResponse(
        String accessToken,
        long expiresIn,
        String tokenType

) {

}
