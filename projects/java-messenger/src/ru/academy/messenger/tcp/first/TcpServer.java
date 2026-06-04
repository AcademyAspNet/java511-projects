package ru.academy.messenger.tcp.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    static void main() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(27015)) {

            System.out.println("Серверный сокет инициализирован");
            Socket clientSocket = serverSocket.accept();

            System.out.println("Клиент подключился к серверу!");

            PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream(),
                    true
            );

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            while (!clientSocket.isClosed()) {
                String receivedMessage = reader.readLine();

                System.out.println(
                        "От клиента получено сообщение: " + receivedMessage
                );

                String reversedMessage = new StringBuilder(receivedMessage)
                        .reverse()
                        .toString();

                writer.println(reversedMessage);

                System.out.println(
                        "Перевернули символы в строке: " + reversedMessage
                );
            }
        }
    }
}
