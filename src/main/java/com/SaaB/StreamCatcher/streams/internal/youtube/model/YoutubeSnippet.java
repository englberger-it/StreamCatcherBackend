package com.SaaB.StreamCatcher.streams.internal.youtube.model;

import java.time.LocalDateTime;
import java.util.Map;

public record YoutubeSnippet(LocalDateTime publishedAt, String channelId, String title, String description,
                             Map<String, YoutubeThumbnail> thumbnails, String channelTitle, String liveBroadcastContent,
                             String publishTime) {
}
