package com.SaaB.StreamCatcher.streams;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController("/streams")
@AllArgsConstructor
public class StreamsRestService {

    private StreamsService streamsService;

    @GetMapping("/name/{name}")
    public Stream<StreamData> getStreamDataByName(@PathVariable String name) {
        return streamsService.getStreamDataByName(name);
    }
}
