package ru.academy.messenger.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class UdpServer {

    public static final int PORT = 27015;
    public static final int BUFFER_SIZE = 8192;

    static void main() throws IOException {
        byte[] datagramPacketBuffer = new byte[BUFFER_SIZE];

        try (DatagramSocket datagramSocket = new DatagramSocket(PORT)) {
            while (!datagramSocket.isClosed()) {
                DatagramPacket datagramPacket = new DatagramPacket(datagramPacketBuffer, BUFFER_SIZE);
                datagramSocket.receive(datagramPacket);

                String message = new String(
                        datagramPacket.getData(),
                        datagramPacket.getOffset(),
                        datagramPacket.getLength(),
                        StandardCharsets.UTF_8
                );

                System.out.println(message);
            }
        }
    }
}
