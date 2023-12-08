package com.SaaB.StreamCatcher.streams.internal;

import com.SaaB.StreamCatcher.streams.StreamData;

import java.util.stream.Stream;

public interface StreamProvider {
    Stream<StreamData> getStreamDataByName(String name);
}
