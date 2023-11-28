package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitchRestService {

    private static final String TWITCH_API_BASE_URL = "https://api.twitch.tv/helix";

    @Value("${saab.streamcatcher.apikeys.twitch.clientId}")
    private String clientId;
    @Value("${saab.streamcatcher.apikeys.twitch.clientSecret}")
    private String clientSecret;

    public String getStreamerData(String streamerName) {
        String accessToken = getAccessToken();

        // Make a request to the Twitch API to get stream data for the specified streamer
        String apiUrl = TWITCH_API_BASE_URL + "/streams?user_login=" + streamerName;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(apiUrl, String.class);

        // Process the result as needed
        return result;
    }

    private String getAccessToken() {
        // make post to https://id.twitch.tv/oauth2/token
        // with body:
        // client_id=YOUR_CLIENT_ID
        // client_secret=YOUR_CLIENT_SECRET
        // grant_type=client_credentials
        // returns json with access_token and expires_in and token_type
        // Make a request to Twitch to obtain an access token using your client ID and client secret
        // Implement the logic to get the access token using OAuth 2.0

        // For simplicity, you can use a hardcoded access token (not recommended for production)
        return "YOUR_ACCESS_TOKEN";
    }
}
