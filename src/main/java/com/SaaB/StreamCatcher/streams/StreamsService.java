package com.SaaB.StreamCatcher.streams;

import com.SaaB.StreamCatcher.streams.internal.StreamProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class StreamsService {

    private List<StreamProvider> streamProvider;

    public Stream<StreamData> getStreamDataByName(String name) {
        return streamProvider.stream().flatMap(provider->provider.getStreamDataByName(name));
    }
    
}
