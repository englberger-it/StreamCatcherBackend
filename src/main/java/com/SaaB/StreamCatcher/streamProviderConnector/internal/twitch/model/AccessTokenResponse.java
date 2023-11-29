package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

import java.time.LocalDateTime;

public record AccessTokenResponse(
        String accessToken,
        long expiresIn,
        String tokenType

) {

}
