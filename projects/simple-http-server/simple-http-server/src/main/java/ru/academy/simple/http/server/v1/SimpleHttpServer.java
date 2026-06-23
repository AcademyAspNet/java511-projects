package ru.academy.simple.http.server.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHttpServer {

    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;

    private static final int DEFAULT_HTTP_PORT = 80;

    private final int port;

    public SimpleHttpServer(int port) {
        if (port < MIN_PORT || port > MAX_PORT)
            throw new IllegalArgumentException("Invalid port value: " + port);

        this.port = port;
    }

    public SimpleHttpServer() {
        this(DEFAULT_HTTP_PORT);
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!serverSocket.isClosed()) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClientSocket(clientSocket);
                }
            }
        }
    }

    private void handleClientSocket(Socket clientSocket) throws IOException {
        // TODO: Используйте код ниже как основу для работы с данными HTTP-запроса:
//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(clientSocket.getInputStream())
//        );
//
//        String line;
//
//        while ((line = reader.readLine()) != null && !line.isEmpty()) {
//            System.out.println(line);
//        }

        InputStream inputStream = clientSocket.getInputStream();
        HttpRequest httpRequest = readHttpRequest(inputStream);

        String htmlContent =
                "<html>" +
                    "<body>" +
                        "<h1>Привет, мир! Текущая дата: " + new Date() + "</h1>" +
                    "</body>" +
                "</html>";

        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println("Content-Length: " + htmlContent.getBytes().length);
        writer.println();
        writer.println(htmlContent);

        writer.flush();
    }

    private HttpRequest readHttpRequest(InputStream clientInputStream) {
        // TODO: Реализуйте логику класса HttpRequest и этого метода (readHttpRequest).
        return null;
    }
}
