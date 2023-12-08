package com.SaaB.StreamCatcher.streams.internal.youtube.model;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.StreamProviderType;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public record YoutubeSearchResult(
        YoutubeResultId id,
        YoutubeSnippet snippet,
        String channelTitle,
        String liveBroadcastContent
) {
    public StreamData toStreamData() {
        return new StreamData(
                StreamProviderType.YOUTUBE,
                id.videoId(),
                id.channelId(),
                channelTitle, // correct user name?
                null,
                snippet.title(),
                snippet.publishedAt(),
                null,
                Optional.ofNullable(snippet.thumbnails()).map(map -> map.get("default"))
                        .map(YoutubeThumbnail::url)
                        .orElseGet(() ->
                                Optional.ofNullable(snippet.thumbnails())
                                        .map(Map::values)
                                        .orElse(Set.of())
                                        .stream()
                                        .findFirst()
                                        .map(YoutubeThumbnail::url)
                                        .orElse(null)),
                false
        );
    }
}
