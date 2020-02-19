package com.ant.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testFailing() {
        assertEquals(1, 2);
    }

    @Test
    public void testApp() {
        System.out.println("hello test!");
    }

}
