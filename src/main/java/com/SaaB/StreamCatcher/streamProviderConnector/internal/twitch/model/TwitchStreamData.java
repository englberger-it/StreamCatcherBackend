package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

import com.SaaB.StreamCatcher.streamProviderConnector.StreamData;
import com.SaaB.StreamCatcher.streamProviderConnector.StreamProviderType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A stream returned by the twitch api.
 *
 * @param id            the id of the stream
 * @param user_id       the id of the user
 * @param user_login    the login name of the user
 * @param user_name     the display name of the user
 * @param game_id       the id of the game
 * @param game_name     the name of the game
 * @param type          is "live" or empty
 * @param title         the title of the stream
 * @param tags          the tags of the stream
 * @param viewer_count  the number of viewers
 * @param started_at    the time the stream started format 2021-03-10T15:04:21Z,
 * @param language      the language of the stream
 * @param thumbnail_url the url of the thumbnail format "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
 * @param is_mature     A Boolean value that indicates whether the stream is meant for mature audiences.
 */
public record TwitchStreamData(
        String id,
        String user_id,
        String user_login,
        String user_name,
        String game_id,
        String game_name,
        String type,
        String title,
        String[] tags,
        long viewer_count,
        String started_at,
        String language,
        String thumbnail_url,
        boolean is_mature
) {
    public StreamData toStreamData() {
        return new StreamData(
                StreamProviderType.TWITCH,
                id,
                user_id,
                user_name,
                game_name,
                title,
                tags,
                LocalDateTime.parse(started_at, DateTimeFormatter.ISO_DATE_TIME),
                language,
                thumbnail_url,
                is_mature
        );
    }
}
