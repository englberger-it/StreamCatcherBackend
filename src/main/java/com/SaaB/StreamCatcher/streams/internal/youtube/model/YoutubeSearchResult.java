package com.SaaB.StreamCatcher.streams.internal.youtube.model;

import com.SaaB.StreamCatcher.streams.StreamData;
import com.SaaB.StreamCatcher.streams.StreamProviderType;

import java.util.Optional;

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
                Optional.ofNullable(snippet.thumbnails().get("default"))
                        .map(YoutubeThumbnail::url)
                        .orElseGet(() ->
                                snippet.thumbnails().values().stream()
                                        .findFirst()
                                        .map(YoutubeThumbnail::url)
                                        .orElse(null)),
                false
        );
    }
}
