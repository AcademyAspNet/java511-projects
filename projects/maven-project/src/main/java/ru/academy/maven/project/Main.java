package ru.academy.maven.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    static void main() {
        logger.debug("Создаем новый экземпляр класса Person...");

        Person tom = new Person("Tom");
        logger.debug("Новый экземпляр класса Person создан!");

        logger.debug("Вызываем метод sayHello() у созданного экземпляра класса Person...");
        tom.sayHello();
    }
}
