package com.SaaB.StreamCatcher.streams.internal.youtube.model;

/**
 * Returned by the twitch api. Holds the streams and the pagination object. see <a href="https://dev.twitch.tv/docs/api/reference#get-streams"/>
 */
public record YoutubeStreamResponse(
        // "kind": "youtube#searchListResponse",
        //"etag": etag,
        String nextPageToken,
        String prevPageToken,
        String regionCode,
        YoutubePageInfo pageInfo,
        YoutubeSearchResult[] items
) {
}
