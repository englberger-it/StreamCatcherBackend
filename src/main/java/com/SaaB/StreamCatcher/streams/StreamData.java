package com.SaaB.StreamCatcher.streams;

import java.time.LocalDateTime;

/**
 * A stream returned by the twitch api.
 *
 * @param id           the id of the stream
 * @param userId       the id of the user
 * @param userName     the display name of the user
 * @param gameName     the name of the game
 * @param title        the title of the stream
 * @param tags         the tags of the stream
 * @param startedAt    the time the stream started format 2021-03-10T15:04:21Z,
 * @param language     the language of the stream
 * @param thumbnailUrl the url of the thumbnail format "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
 * @param isMature     A Boolean value that indicates whether the stream is meant for mature audiences.
 */
public record StreamData(
        StreamProviderType streamProviderType,
        String id,
        String userId,
        String userName,
        String gameName,
        String title,
        String[] tags,
        LocalDateTime startedAt,
        String language,
        String thumbnailUrl,
        boolean isMature
) {
}

