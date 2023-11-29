package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

public record AccessTokeRequest(
        String clientId,
        String clientSecret,
        String grantType
) {
}
