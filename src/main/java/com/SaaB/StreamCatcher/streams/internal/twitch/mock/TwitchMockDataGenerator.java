package com.SaaB.StreamCatcher.streams.internal.twitch.mock;

import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.stream.Stream;

import static com.SaaB.StreamCatcher.streams.internal.util.MockUtil.generateRandomString;

@Slf4j
public class TwitchMockDataGenerator {

    static Stream<TwitchStreamData> getMockStreamDataByName(String name) {
        int numberOfStreams = new Random().nextInt(10);
        log.info("Generating {} mock streams for {}", numberOfStreams, name);

        return Stream.generate(() -> getStreamForName(name)).limit(numberOfStreams);
    }

    private static TwitchStreamData getStreamForName(String name) {
        return new TwitchStreamData(
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


}
