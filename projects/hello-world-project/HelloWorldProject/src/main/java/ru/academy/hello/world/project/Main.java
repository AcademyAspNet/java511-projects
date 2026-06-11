package ru.academy.hello.world.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Main {

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    static void main() {
        new Main().start();
    }

    public void start() {
        logger.info("Hello, world!");
    }
}
