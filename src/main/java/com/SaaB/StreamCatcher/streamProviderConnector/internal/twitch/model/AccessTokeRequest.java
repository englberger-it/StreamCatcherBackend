package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

/**
 * The request body for the access token request. See <a href="https://dev.twitch.tv/docs/authentication/getting-tokens-oauth#oauth-client-credentials-flow"/>
 *
 * @param clientId     the client id of the application
 * @param clientSecret the client secret of the application
 * @param grantType    the grant type of the application
 */
public record AccessTokeRequest(
        String clientId,
        String clientSecret,
        String grantType
) {
}
