package com.SaaB.StreamCatcher.streamProviderConnector;

import com.SaaB.StreamCatcher.streamProviderConnector.internal.StreamData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StreamProviderConnectorServiceTest {

    @Autowired
    private StreamProviderConnectorService streamProviderConnectorService;

    @Test
    void getStreamDataByName() {
        Stream<StreamData> data = streamProviderConnectorService.getStreamDataByName("test");
        assertEquals(List.of(new StreamData("1"),new StreamData("2")),data.collect(Collectors.toList()));
    }
}