package com.SaaB.StreamCatcher.streams.internal.twitch.model;

/**
 * Returned by the twitch api. Holds the streams and the pagination object. see <a href="https://dev.twitch.tv/docs/api/reference#get-streams"/>
 *
 * @param data       the returned streams
 * @param pagination the pagination object
 */
public record TwitchStreamResponse(
        TwitchStreamData[] data,
        PaginationResponse pagination
) {
}
