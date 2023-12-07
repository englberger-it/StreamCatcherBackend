package com.SaaB.StreamCatcher.streams.internal.youtube;

import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubeStreamResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class YoutubeApiServiceImpl implements YoutubeApiService {

    private static final String TWITCH_API_BASE_URL = "https://api.twitch.tv/helix";
    private static final String TWITCH_OAUTH_BASE_URL = "https://id.twitch.tv/oauth2";

    @Value("${saab.streamcatcher.apikeys.youtube.clientId}")
    private String clientId;
    @Value("${saab.streamcatcher.apikeys.youtube.clientSecret}")
    private String clientSecret;


    public YoutubeStreamResponse getStreamsByName(String streamerName) {
        throw new UnsupportedOperationException("Youtube API is not implemented yet");

        // call https://www.googleapis.com/youtube/v3/search
        // with parameters channelId (we have to get this somehow, perhaps store)
        //       call https://www.googleapis.com/youtube/v3/channels mit forUsername
        // and eventType: live

    }
    // vermtulich müssen wir diese Api callen  https://developers.google.com/apis-explorer/#p/youtube/v3/youtube.search.list?
    //        part=snippet
    //        &q=travel
    //        &type=channel
    // Quelle: https://developers.google.com/youtube/v3/docs/search/list?hl=de

}
/**
 * Sample Java code for youtube.channels.list
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/code-samples#java
 */


// Quelle:  https://developers.google.com/youtube/v3/docs/channels/list?hl=de&apix=true

//import com.google.api.client.auth.oauth2.Credential;
//        import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//        import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//        import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//        import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//        import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//        import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//        import com.google.api.client.http.javanet.NetHttpTransport;
//        import com.google.api.client.json.JsonFactory;
//        import com.google.api.client.json.jackson2.JacksonFactory;
//
//        import com.google.api.services.youtube.YouTube;
//        import com.google.api.services.youtube.model.ChannelListResponse;
//
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.io.InputStreamReader;
//        import java.security.GeneralSecurityException;
//        import java.util.Arrays;
//        import java.util.Collection;
//
//public class ApiExample {
//    private static final String CLIENT_SECRETS= "client_secret.json";
//    private static final Collection<String> SCOPES =
//            Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");
//
//    private static final String APPLICATION_NAME = "API code samples";
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

//    /**
//     * Create an authorized Credential object.
//     *
//     * @return an authorized Credential object.
//     * @throws IOException
//     */
//    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
//        // Load client secrets.
//        InputStream in = ApiExample.class.getResourceAsStream(CLIENT_SECRETS);
//        GoogleClientSecrets clientSecrets =
//                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow =
//                new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
//                        .build();
//        Credential credential =
//                new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//        return credential;
//    }
//
//    /**
//     * Build and return an authorized API client service.
//     *
//     * @return an authorized API client service
//     * @throws GeneralSecurityException, IOException
//     */
//    public static YouTube getService() throws GeneralSecurityException, IOException {
//        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        Credential credential = authorize(httpTransport);
//        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }


