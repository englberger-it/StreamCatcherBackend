package com.SaaB.StreamCatcher.streamProviderConnector.internal;

import java.util.stream.Stream;

public interface StreamProvider {
   Stream<StreamData> getStreamDataByName(String name);
}
