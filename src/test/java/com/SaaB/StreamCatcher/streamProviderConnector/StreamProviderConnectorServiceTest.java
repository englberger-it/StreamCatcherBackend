package com.SaaB.StreamCatcher.streamProviderConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class StreamProviderConnectorServiceTest {

    @Autowired
    private StreamProviderConnectorService streamProviderConnectorService;

//    @Test
//    void getStreamDataByName() {
//        Stream<StreamData> data = streamProviderConnectorService.getStreamDataByName("test");
//        assertEquals(List.of(new StreamData("1"),new StreamData("2")),data.collect(Collectors.toList()));
//    }
}