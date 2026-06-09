package ru.academy.messenger.tcp.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    private static final String HOST = "127.0.0.1";

    static void main() throws IOException {
        try (Socket socket = new Socket(HOST, Server.PORT);
             Scanner scanner = new Scanner(System.in)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();

            while (!socket.isClosed()) {
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    outputStream.write(Command.CLOSE_CONNECTION);
                    outputStream.flush();

                    break;
                }

                outputStream.write(Command.GET_QUOTE);
                outputStream.flush();

                String quote = reader.readLine();
                System.out.println("Цитата: " + quote);
            }
        }
    }
}
