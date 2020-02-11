package com.fs.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MetricsRecorder {

    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void recordTimeMetric(final String name, final long durationInMillis) {
        logger.info("Metric type LATENCY name: {}, duration: {}", name, durationInMillis);
    }

}