package com.SaaB.StreamCatcher.streams.internal.twitch;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.StreamProviderType;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwitchServiceTest {

    @MockBean
    private TwitchApiService twitchApiService;

    @Test
    void getStreamDataByName() {
        var mockData = getMockStreamData();
        Mockito.when(twitchApiService.getStreamsByName("test")).thenReturn(mockData);
        var twitchConnector = new TwitchService(twitchApiService);
        assertEquals(getMockStreamDataConverted(), twitchConnector.getStreamDataByName("test"));
    }


    private Stream<TwitchStreamData> getMockStreamData() {
        var mockData0 = new TwitchStreamData(
                "streamID",
                "userID",
                "userLogin",
                "userName",
                "gameID",
                "gameName",
                "type",
                "title",
                new String[]{"tag0", "tag2"},
                99,
                "2020-03-10T15:04:21Z",
                "language",
                "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
                true
        );

        return Stream.of(mockData0);
    }

    private Stream<StreamData> getMockStreamDataConverted() {
        var mockData0 = new StreamData(
                StreamProviderType.TWITCH,
                "streamID",
                "userID",
                "userName",
                "gameName",
                "title",
                new String[]{"tag0", "tag2"},
                LocalDateTime.of(2020, Month.MARCH, 10, 15, 4, 21, 0),
                "language",
                "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
                true
        );

        return Stream.of(mockData0);
    }

}