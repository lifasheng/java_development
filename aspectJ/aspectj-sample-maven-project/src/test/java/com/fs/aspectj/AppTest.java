package com.fs.aspectj;

import org.junit.Test;

public class AppTest {
    @Test
    public void testApp() {
        App app = new App();
        app.walk();
        System.out.println(app.talk());
    }
}
