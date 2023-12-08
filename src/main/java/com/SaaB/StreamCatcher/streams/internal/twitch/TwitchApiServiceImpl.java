package com.SaaB.StreamCatcher.streams.internal.twitch;

import com.SaaB.StreamCatcher.streams.internal.twitch.model.AccessToken;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.AccessTokenResponse;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Profile("prod")
public class TwitchApiServiceImpl implements TwitchApiService {

    private static final String TWITCH_API_BASE_URL = "https://api.twitch.tv/helix";
    private static final String TWITCH_OAUTH_BASE_URL = "https://id.twitch.tv/oauth2";

    @Value("${saab.streamcatcher.apikeys.twitch.clientId}")
    private String clientId;
    @Value("${saab.streamcatcher.apikeys.twitch.clientSecret}")
    private String clientSecret;

    private AccessToken accessToken;

    public Stream<TwitchStreamData> getStreamsByName(String streamerName) {
//        String accessToken = getAccessToken();

        // Make a request to the Twitch API to get stream data for the specified streamer
        String apiUrl = TWITCH_API_BASE_URL + "/streams?user_login=" + streamerName;
        RestTemplate restTemplate = new RestTemplate();

        // Process the result as needed
        return Arrays.stream(Optional.ofNullable(restTemplate.getForObject(apiUrl, TwitchStreamResponse.class))
                                     .orElseThrow(() -> new IllegalStateException("no response from twitch"))
                                     .data());
    }

    private String getAccessToken() {
        if (accessToken == null || accessToken.isExpired()) {
            var accessTokenResponse = Optional.ofNullable(new RestTemplate().postForObject(
                            TWITCH_OAUTH_BASE_URL + "/token?client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials",
                            null, AccessTokenResponse.class))
                    .orElseThrow(() -> new IllegalStateException("Could not get access token"));
            accessToken = AccessToken.fromAccessTokenResponse(accessTokenResponse);
        }
        return accessToken.token();
    }

    // TODO implement EventSub when a broadcaster goes live https://dev.twitch.tv/docs/eventsub/
}
