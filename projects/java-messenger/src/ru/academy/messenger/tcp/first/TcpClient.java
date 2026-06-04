package ru.academy.messenger.tcp.first;

import java.io.*;
import java.net.Socket;

public class TcpClient {

    static void main() throws IOException, InterruptedException {
        System.out.println("Подключение к серверу...");

        try (Socket socket = new Socket("127.0.0.1", 27015)) {

            System.out.println("Соединение успешно установлено!");

            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            while (!socket.isClosed()) {
                String message = IO.readln("Введите Ваше сообщение: ");
                writer.println(message);

                String receivedMessage = reader.readLine();
                System.out.println("Сообщение от сервера: " + receivedMessage);
            }
        }
    }
}
