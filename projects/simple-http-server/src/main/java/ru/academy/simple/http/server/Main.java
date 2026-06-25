package ru.academy.simple.http.server;

import ru.academy.simple.http.server.v1.SimpleHttpServer;

import java.io.IOException;

public class Main {

    static void main() {
        SimpleHttpServer httpServer = new SimpleHttpServer();

        try {
            httpServer.start();
        } catch (IOException exception) {
            System.err.println("При работе сервера возникла ошибка!");
            exception.printStackTrace();
        }
    }
}
