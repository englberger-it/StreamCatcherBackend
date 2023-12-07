package com.SaaB.StreamCatcher.streams.internal.youtube.mock;

import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubePageInfo;
import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubeSearchResult;
import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubeStreamResponse;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Stream;

@Slf4j
public class YoutubeMockDataGenerator {

    static YoutubeStreamResponse getMockStreamDataByName(String name) {
        int numberOfStreams = new Random().nextInt(10);
        log.info("Generating {} mock streams for {}", numberOfStreams, name);

        var items = Stream.generate(() -> getStreamForName(name)).limit(numberOfStreams).toArray(YoutubeSearchResult[]::new);
        return new YoutubeStreamResponse(
                "",
                "",
                "",
                new YoutubePageInfo(numberOfStreams, numberOfStreams),
                items
        );
    }

    private static YoutubeSearchResult getStreamForName(String name) {
        return new YoutubeSearchResult(
                generateRandomString(8),
                generateRandomString(10),
                generateRandomString(10),
                name,
                generateRandomString(10),
                generateRandomString(10),
                generateRandomString(10),
                generateRandomString(10),
                new String[]{"tag0", "tag2"},
                new Random().nextInt(),
                "2020-03-10T15:04:21Z",
                "language",
                "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
                new Random().nextBoolean()
        );
    }

    private static String generateRandomString(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
