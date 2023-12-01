package com.SaaB.StreamCatcher.streams.internal.twitch;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.internal.StreamProvider;
import com.SaaB.StreamCatcher.streams.internal.twitch.model.TwitchStreamData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class TwitchService implements StreamProvider {

    private final TwitchApiService twitchApiService;

    @Override
    public Stream<StreamData> getStreamDataByName(String name) {
        return twitchApiService.getStreamsByName(name)
                .map(TwitchStreamData::toStreamData);
    }


}
