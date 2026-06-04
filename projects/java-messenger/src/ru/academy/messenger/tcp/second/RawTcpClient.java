package ru.academy.messenger.tcp.second;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class RawTcpClient {

    private static final String HOST = "127.0.0.1";

    static void main() throws IOException {
        try (Socket socket = new Socket(HOST, RawTcpServer.PORT);
             Scanner scanner = new Scanner(System.in)) {

            OutputStream outputStream = socket.getOutputStream();

            while (!socket.isClosed()) {
                System.out.print("Введите сообщение: ");
                String message = scanner.nextLine();

                byte[] messageAsByteArray = message.getBytes(StandardCharsets.UTF_8);
                int bytesInArray = messageAsByteArray.length;

                byte[] encodedBytesInArray = {
                        (byte) (bytesInArray >>> 24),
                        (byte) (bytesInArray >>> 16),
                        (byte) (bytesInArray >>> 8),
                        (byte) bytesInArray
                };

                outputStream.write(encodedBytesInArray);
                outputStream.write(messageAsByteArray);
            }
        }
    }
}
