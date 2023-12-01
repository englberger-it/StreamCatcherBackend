package com.SaaB.StreamCatcher.streams.internal.twitch.model;

/**
 * Values to add to the request as query parameters to page through the results. see <a href="https://dev.twitch.tv/docs/api/guide#pagination"/>
 *
 * @param after  set the cursor value from the previous response here to get the next page
 * @param before set the cursor value from the previous response here to get the previous page
 * @param first  number of elements to return
 */
record PaginationRequest(
        String after,
        String before,
        int first
) {
}
