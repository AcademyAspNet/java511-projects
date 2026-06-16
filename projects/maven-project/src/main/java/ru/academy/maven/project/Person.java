package ru.academy.maven.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {

    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello() {
        logger.info("{} передает привет!", name);
    }
}
