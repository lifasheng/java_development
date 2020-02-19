package com.ant.test;

import com.ant.test.Service.UserService;
import org.apache.log4j.Logger;

public class App {

    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        UserService userService = new UserService();
        final String user = userService.getUserById(12);
        logger.info("Hello World! " + user);
    }
}
