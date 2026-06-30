package ru.academy.simple.http.server;

import ru.academy.simple.http.server.v1.SimpleHttpServer;
import ru.academy.simple.http.server.v2.StaticHttpServer;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    static void main() {
        Path rootDirectoryPath = Path.of("static");
        var httpServer = new StaticHttpServer(rootDirectoryPath);

        try {
            httpServer.start();
        } catch (IOException exception) {
            System.err.println("При работе сервера возникла ошибка!");
            exception.printStackTrace();
        }
    }
}
