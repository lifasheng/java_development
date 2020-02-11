package com.fs.aspectj.aspects;

import com.fs.aspectj.MetricsRecorder;
import com.fs.aspectj.annotations.Metric;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.time.Duration;
import java.time.Instant;

@Aspect
public class TimingMetricsAspect extends AbstractMetricsAspect {

    /**
     * Appended to the metric name (specified using the {@link Metric} annotation's {@link Metric#name()} property).
     */
    private static final String METRIC_NAME_SUFFIX = "time";

    @Pointcut("@annotation(com.fs.aspectj.annotations.TimeMetric)")
    public void pointcutTimeMetricAnnotation() {
    }

    @Around("pointcutMethodExecutionWithMetricAnnotation(metric) && pointcutTimeMetricAnnotation()")
    public Object recordTimingMetrics(final ProceedingJoinPoint pjp, final Metric metric) throws Throwable {
        final Instant start = Instant.now();

        final Object result = pjp.proceed();

        final long elapsedTime = Duration.between(start, Instant.now()).toMillis();

        final String metricName = getMetricName(metric, METRIC_NAME_SUFFIX);
        final MetricsRecorder metricsRecorder = new MetricsRecorder();
        metricsRecorder.recordTimeMetric(metricName, elapsedTime);

        return result;
    }

}

