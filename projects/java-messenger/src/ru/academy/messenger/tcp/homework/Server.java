package ru.academy.messenger.tcp.homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 27015;

    private static final String[] QUOTES = {
            "Quote 1",
            "Quote 2",
            "Quote 3"
    };

    static void main() throws IOException {
        int nextQuoteIndex = 0;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket clientSocket = serverSocket.accept();

            InputStream inputStream = clientSocket.getInputStream();
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            while (!clientSocket.isClosed()) {
                byte[] receivedBytes = inputStream.readNBytes(1);

                if (receivedBytes.length == 1) {
                    byte command = receivedBytes[0];

                    switch (command) {
                        case 0:
                            String quote = QUOTES[nextQuoteIndex];
                            nextQuoteIndex++;

                            if (nextQuoteIndex >= QUOTES.length)
                                nextQuoteIndex = 0;

                            printWriter.println(quote);
                            break;
                        case 1:
                            clientSocket.close();
                            break;
                        default:
                            System.out.println("Получена недопустимая команда!");
                    }
                }
            }
        }
    }
}
