package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch;

import com.SaaB.StreamCatcher.streamProviderConnector.StreamData;
import com.SaaB.StreamCatcher.streamProviderConnector.internal.StreamProvider;
import com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model.TwitchStreamData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class TwitchConnector implements StreamProvider {

    private final TwitchApiService twitchApiService;

    @Override
    public Stream<StreamData> getStreamDataByName(String name) {
        return twitchApiService.getStreamsByName(name)
                .map(TwitchStreamData::toStreamData);
    }


}
