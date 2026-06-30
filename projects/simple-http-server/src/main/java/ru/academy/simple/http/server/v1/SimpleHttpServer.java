package ru.academy.simple.http.server.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {

    public static final int DEFAULT_HTTP_PORT = 80;

    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;

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

    protected void handleClientSocket(Socket clientSocket) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        HttpRequestReader reader = new HttpRequestReader(inputStream);

        HttpRequest httpRequest = reader.readHttpRequest();
        String htmlContent = getHtmlContent(httpRequest);

        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println("Content-Length: " + htmlContent.getBytes().length);
        writer.println();
        writer.println(htmlContent);

        writer.flush();
    }

    private String getHtmlContent(HttpRequest httpRequest) {
        String path = httpRequest.path();

        if (path.equalsIgnoreCase("/cat")) {
            return "<html>" +
                        "<body>" +
                            "<h1>Здесь должно быть изображение котика.</h1>" +
                        "</body>" +
                    "</html>";
        }

        if (path.equalsIgnoreCase("/dog")) {
            return "<html>" +
                        "<body>" +
                            "<h1>Здесь должно быть изображение собачки.</h1>" +
                            "<p><i>Привет</i>, мир! <u>Привет всем</u>!</p>" +
                        "</body>" +
                    "</html>";
        }

        return "<html>" +
                    "<body>" +
                        "<h1>К сожалению, такой страницы нет!</h1>" +
                    "</body>" +
                "</html>";
    }
}
