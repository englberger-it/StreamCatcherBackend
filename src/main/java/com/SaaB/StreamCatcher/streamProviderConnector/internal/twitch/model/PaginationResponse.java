package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

/**
 * Returned by the twitch apy. The object is empty if there are no more pages left to page through. see <a href="https://dev.twitch.tv/docs/api/guide#pagination"/>
 * @param cursor set this value as after or before in the next request to get the next page
 */
public record PaginationResponse(
        String cursor
) {
}
