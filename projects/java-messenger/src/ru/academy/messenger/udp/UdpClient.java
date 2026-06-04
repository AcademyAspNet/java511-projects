package ru.academy.messenger.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UdpClient {

    static void main() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите сообщение: ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit"))
                    break;

                byte[] messageAsByteArray = message.getBytes(StandardCharsets.UTF_8);

                InetAddress address = InetAddress.getLoopbackAddress();

                DatagramPacket datagramPacket = new DatagramPacket(
                        messageAsByteArray,
                        messageAsByteArray.length,
                        address,
                        UdpServer.PORT
                );

                try (DatagramSocket datagramSocket = new DatagramSocket()) {
                    datagramSocket.send(datagramPacket);
                }
            }
        }
    }
}
