package com.fs.aspectj.aspects;

import com.fs.aspectj.annotations.Metric;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public abstract class AbstractMetricsAspect {

    @Pointcut("execution(@com.fs.aspectj.annotations.Metric * *(..)) && @annotation(metric)")
    public void pointcutMethodExecutionWithMetricAnnotation(final Metric metric) {
    }

    protected String getTargetSignature(final JoinPoint jp) {
        return jp.getSignature().toShortString();
    }

    protected String getTargetSignature(final ProceedingJoinPoint pjp) {
        return getTargetSignature((JoinPoint) pjp);
    }

    /**
     * Adds a suffix to the metric name declared with {@link Metric#name()} annotation,
     * to distinguish various sub-type of metrics associated with the same method.
     */
    protected String getMetricName(final Metric metric, final String suffix) {
        return String.format("%s-%s", metric.name(), suffix);
    }

}