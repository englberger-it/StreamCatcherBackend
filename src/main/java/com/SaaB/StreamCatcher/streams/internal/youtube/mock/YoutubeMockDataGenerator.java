package com.SaaB.StreamCatcher.streams.internal.youtube.mock;

import com.SaaB.StreamCatcher.streams.internal.youtube.model.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import static com.SaaB.StreamCatcher.streams.internal.util.MockUtil.generateRandomString;

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
                new YoutubeResultId(
                        generateRandomString(8),
                        generateRandomString(8),
                        generateRandomString(8),
                        generateRandomString(8)
                ),
                new YoutubeSnippet(
                        LocalDateTime.now()
                                .minusDays(new Random().nextInt(100)),
                        generateRandomString(8),
                        generateRandomString(10),
                        generateRandomString(10),
                        Map.of(
                                "default",
                                new YoutubeThumbnail(
                                        generateRandomString(10),
                                        new Random().nextInt(100),
                                        new Random().nextInt(100)
                                )
                        ),
                        name,
                        generateRandomString(10),
                        generateRandomString(10)
                ),
                name,
                generateRandomString(10)
        );
    }


}
