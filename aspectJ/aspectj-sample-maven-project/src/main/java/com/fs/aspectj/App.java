package com.fs.aspectj;

import com.fs.aspectj.annotations.Metric;
import com.fs.aspectj.annotations.TimeMetric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Main Application
 *
 */
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Metric(name="appMetric")
    @TimeMetric
    public String talk() {
        log.info("In App.talk");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "say hello to world!";
    }

    @Metric(name="appMetric")
    @TimeMetric
    public void walk(){
        log.info("in App.walk");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void main(String[] args) {
        App app = new App();
        app.walk();
        app.talk();
    }
}
