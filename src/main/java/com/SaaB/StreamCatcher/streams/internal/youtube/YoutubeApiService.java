package com.SaaB.StreamCatcher.streams.internal.youtube;

import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubeStreamResponse;

public interface YoutubeApiService {
    YoutubeStreamResponse getStreamsByName(String streamerName);

}
