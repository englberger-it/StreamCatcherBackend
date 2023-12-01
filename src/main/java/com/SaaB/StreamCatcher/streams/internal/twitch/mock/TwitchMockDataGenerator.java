package com.SaaB.StreamCatcher.streams.internal.twitch.mock;

import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Stream;

public class TwitchMockDataGenerator {

    static Stream<TwitchStreamData> getMockStreamDataByName(String name) {
        var mockData0 = new TwitchStreamData(
                generateRandomString(8),
                generateRandomString(10),
                generateRandomString(10),
                name,
                generateRandomString(10),
                generateRandomString(10),
                generateRandomString(10),
                generateRandomString(10),
                new String[]{"tag0", "tag2"},
                99,
                "2020-03-10T15:04:21Z",
                "language",
                "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
                true
        );

        return Stream.of(mockData0);
    }

    private static String generateRandomString(int length) {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
