package com.SaaB.StreamCatcher.streamProviderConnector.internal;

import com.SaaB.StreamCatcher.streamProviderConnector.StreamData;

import java.util.stream.Stream;

public interface StreamProvider {
   Stream<StreamData> getStreamDataByName(String name);
}
