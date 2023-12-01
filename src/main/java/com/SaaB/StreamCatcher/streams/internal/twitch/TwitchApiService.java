package com.SaaB.StreamCatcher.streams.internal.twitch;

import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;

import java.util.stream.Stream;

public interface TwitchApiService {
    Stream<TwitchStreamData> getStreamsByName(String streamerName);

}
