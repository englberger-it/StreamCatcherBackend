package com.SaaB.StreamCatcher.api.publicApi;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.StreamsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class PublicRestService {

    private final StreamsService streamsService;

    @GetMapping("/streams/name/{name}")
    public List<StreamData> getStreamDataByName(@PathVariable String name) {
        log.info("getStreamDataByName: {}", name);
        return streamsService
                .getStreamDataByName(name)
                .collect(Collectors.toList());
    }
}
