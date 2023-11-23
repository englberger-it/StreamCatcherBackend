package com.SaaB.StreamCatcher.streamProviderConnector;

import com.SaaB.StreamCatcher.streamProviderConnector.internal.StreamData;
import com.SaaB.StreamCatcher.streamProviderConnector.internal.StreamProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class StreamProviderConnectorService {

    private List<StreamProvider> streamProvider;

    public Stream<StreamData> getStreamDataByName(String name) {
        return streamProvider.stream().flatMap(provider->provider.getStreamDataByName(name));
    }
    
}
