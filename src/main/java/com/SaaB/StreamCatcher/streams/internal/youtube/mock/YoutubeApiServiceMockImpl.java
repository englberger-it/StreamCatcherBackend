package com.SaaB.StreamCatcher.streams.internal.youtube.mock;

import com.SaaB.StreamCatcher.streams.internal.youtube.YoutubeApiService;
import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubeStreamResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!prod")
public class YoutubeApiServiceMockImpl implements YoutubeApiService {
    @Override
    public YoutubeStreamResponse getStreamsByName(String streamerName) {
        return YoutubeMockDataGenerator.getMockStreamDataByName(streamerName);
    }
}
