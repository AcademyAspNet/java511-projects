package ru.academy.messenger.tcp.second;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class RawTcpServer {

    public static final int PORT = 27015;

    static void main() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            try (Socket clientSocket = serverSocket.accept()) {

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                while (!clientSocket.isClosed()) {
                    byte[] encodedBytesInArray = inputStream.readNBytes(4);

                    int bytesInArray =
                            ((encodedBytesInArray[0] & 0xFF) << 24) |
                            ((encodedBytesInArray[1] & 0xFF) << 16) |
                            ((encodedBytesInArray[2] & 0xFF) << 8) |
                            (encodedBytesInArray[3] & 0xFF);

                    byte[] messageAsByteArray = inputStream.readNBytes(bytesInArray);
                    String message = new String(messageAsByteArray, StandardCharsets.UTF_8);

                    System.out.println(message);
                }
            }
        }
    }
}
