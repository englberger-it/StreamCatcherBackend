package com.SaaB.StreamCatcher.streams.internal.youtube;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.internal.StreamProvider;
import com.SaaB.StreamCatcher.streams.internal.youtube.model.YoutubeSearchResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class YoutubeService implements StreamProvider {

    private final YoutubeApiService youtubeApiService;

    @Override
    public Stream<StreamData> getStreamDataByName(String name) {
        return Arrays
                .stream(youtubeApiService
                                .getStreamsByName(name)
                                .items())
                .map(YoutubeSearchResult::toStreamData);
    }
}
