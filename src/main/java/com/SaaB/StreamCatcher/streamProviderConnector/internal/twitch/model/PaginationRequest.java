package com.SaaB.StreamCatcher.streamProviderConnector.internal.twitch.model;

/**
 * Values to add to the request as query parameters to page through the results. see <a href="https://dev.twitch.tv/docs/api/guide#pagination"/>
 * @param after set the cursor value from the previous response here to get the next page
 * @param before set the cursor value from the previous response here to get the previous page
 * @param first number of elements to return
 */
record PaginationRequest(
        String after, // set the cursor value from the previous response here to get the next page
        String before, // set the cursor value from the previous response here to get the previous page
        int first // number of elements to return
) {
}
