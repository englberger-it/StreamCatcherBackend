package com.SaaB.StreamCatcher.streams.internal.twitch.mock;

import com.SaaB.StreamCatcher.streams.internal.twitch.TwitchApiService;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@Profile("!prod")
public class TwitchApiServiceMockImpl implements TwitchApiService {
    @Override
    public Stream<TwitchStreamData> getStreamsByName(String streamerName) {
        return TwitchMockDataGenerator.getMockStreamDataByName(streamerName);
    }
}
