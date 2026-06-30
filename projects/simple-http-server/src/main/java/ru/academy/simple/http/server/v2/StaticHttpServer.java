package ru.academy.simple.http.server.v2;

import ru.academy.simple.http.server.v1.HttpRequest;
import ru.academy.simple.http.server.v1.HttpRequestReader;
import ru.academy.simple.http.server.v1.SimpleHttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticHttpServer extends SimpleHttpServer {

    private final Path rootDirectoryPath;

    public StaticHttpServer(Path rootDirectoryPath, int port) {
        super(port);
        this.rootDirectoryPath = rootDirectoryPath;
    }

    public StaticHttpServer(Path rootDirectoryPath) {
        this(rootDirectoryPath, DEFAULT_HTTP_PORT);
    }

    @Override
    protected void handleClientSocket(Socket clientSocket) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        HttpRequestReader httpRequestReader = new HttpRequestReader(inputStream);

        HttpRequest httpRequest = httpRequestReader.readHttpRequest();

        String rawRelativeResourcePath = httpRequest.path().substring(1);
        String relativeResourcePath = URLDecoder.decode(rawRelativeResourcePath, StandardCharsets.UTF_8);

        Path resourcePath = rootDirectoryPath.resolve(relativeResourcePath);

        System.out.println("Браузер запрашивает ресурс: " + relativeResourcePath);
        System.out.println("Предполагаем, что ресурс находится: " + resourcePath);

        OutputStream outputStream = clientSocket.getOutputStream();

        String fileExtension = getFileExtension(resourcePath);
        System.out.println("Расширение файла: " + fileExtension);

        if (!Files.exists(resourcePath) || Files.isDirectory(resourcePath)) {
            String htmlContent = "<h1>К сожалению, запрашиваемый ресурс не найден!</h1>";

            sendResponse(
                    outputStream,
                    "404 Not Found",
                    "text/html; charset=UTF-8",
                    htmlContent.getBytes()
            );

            return;
        }

        String mimeType = getMimeTypeFromFilePath(resourcePath);
        byte[] fileContent = Files.readAllBytes(resourcePath);

        sendResponse(
                outputStream,
                "200 OK",
                mimeType,
                fileContent
        );
    }

    private void sendResponse(OutputStream outputStream, String status, String mimeType, byte[] body) throws IOException {
        try (PrintWriter writer = new PrintWriter(outputStream, true)) {
            writer.println("HTTP/1.1 " + status);
            writer.println("Content-Type: " + mimeType);
            writer.println("Content-Length: " + body.length);
            writer.println();

            outputStream.write(body);
            outputStream.flush();
        }
    }

    private String getFileExtension(Path filePath) {
        String filePathAsString = filePath.toString();
        int lastDotPosition = filePathAsString.lastIndexOf('.');

        if (lastDotPosition == -1)
            return null;

        return filePathAsString.substring(lastDotPosition + 1);
    }

    private String getMimeTypeFromFilePath(Path filePath) {
        String fileExtension = getFileExtension(filePath);

        if (fileExtension.equalsIgnoreCase("HTML"))
            return "text/html; charset=UTF-8";

        if (fileExtension.equalsIgnoreCase("TXT"))
            return "text/plain; charset=UTF-8";

        if (fileExtension.equalsIgnoreCase("PNG"))
            return "image/png";

        return "text/plain";
    }
}
