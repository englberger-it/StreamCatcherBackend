package com.SaaB.StreamCatcher.streams.internal.twitch;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.StreamProviderType;
import com.SaaB.StreamCatcher.streams.internal.twitch.mock.TwitchApiServiceMockImpl;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TwitchServiceTest {

    @MockBean
    private TwitchApiServiceMockImpl twitchApiService;

    @Test
    void getStreamDataByName() {
        var mockData = getMockStreamData();
        Mockito.when(twitchApiService.getStreamsByName("test")).thenReturn(mockData);
        var twitchConnector = new TwitchService(twitchApiService);
        assertEquals(getMockStreamDataConverted(), twitchConnector.getStreamDataByName("test").collect(Collectors.toList()));
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

    private List<StreamData> getMockStreamDataConverted() {
        var mockData0 = new StreamData(
                StreamProviderType.TWITCH,
                "streamID",
                "userID",
                "userName",
                "gameName",
                "title",
                LocalDateTime.of(2020, Month.MARCH, 10, 15, 4, 21, 0),
                "language",
                "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
                true
        );

        return List.of(mockData0);
    }

}