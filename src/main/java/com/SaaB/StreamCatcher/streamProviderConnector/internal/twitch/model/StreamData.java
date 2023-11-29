package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

public record StreamData(
        String id,
        String user_id,
        String user_login,
        String user_name,
        String game_id,
        String game_name,
        String type, // is "live" or empty
        String title,
        String[] tags,
        long viewer_count,
        String started_at, // format 2021-03-10T15:04:21Z,
        String language,
        String thumbnail_url,
        //format "https://static-cdn.jtvnw.net/previews-ttv/live_user_auronplay-{width}x{height}.jpg",
        boolean is_mature // A Boolean value that indicates whether the stream is meant for mature audiences.
) {
}
