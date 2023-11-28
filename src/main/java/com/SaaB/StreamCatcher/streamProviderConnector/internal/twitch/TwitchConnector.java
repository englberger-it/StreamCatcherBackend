package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch;

import com.SaaB.StreamCatcher.streamProviderConnector.internal.StreamData;
import com.SaaB.StreamCatcher.streamProviderConnector.internal.StreamProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TwitchConnector implements StreamProvider {
    @Override
    public Stream<StreamData> getStreamDataByName(String name) {
        // write a code to get data from twitch

        var data = List.of(new StreamData("1"), new StreamData("2"));
        return data.stream();
    }
}
