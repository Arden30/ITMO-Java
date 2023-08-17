package client.util_client;

import common.util_common.DeSerializer;
import common.util_common.Request;
import common.util_common.Response;
import common.util_common.Serializer;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public class ClientSocket {
    private final int defaultPort = 3741;
    private final int timeToResponse = 2000;
    private int port;
    private String address = "localhost";
    private InetAddress serverAddress;
    private final DatagramSocket datagramSocket;
    public ClientSocket() throws UnknownHostException, SocketException {
        port = defaultPort;
        datagramSocket = new DatagramSocket();
        serverAddress = InetAddress.getByName(address);
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) throws UnknownHostException {
        this.address = address;
        serverAddress = InetAddress.getByName(address);
    }
    public void sendRequest(Request request) throws IOException {
        ByteBuffer byteBuffer = Serializer.serializeRequest(request);
        byte[] bufferToSend = byteBuffer.array();
        DatagramPacket datagramPacket = new DatagramPacket(bufferToSend, bufferToSend.length, serverAddress, port);
        datagramSocket.send(datagramPacket);
    }

    public Response receiveResponse() throws IOException, ClassNotFoundException {
        datagramSocket.setSoTimeout(timeToResponse);
        byte[] byteBuf = new byte[datagramSocket.getReceiveBufferSize()];
        DatagramPacket dpFromServer = new DatagramPacket(byteBuf, byteBuf.length);
        datagramSocket.receive(dpFromServer);
        byte[] bytesFromServer = dpFromServer.getData();
        return DeSerializer.deSerializeResponse(bytesFromServer);
    }
}
