package server.util_server;

import common.util_common.Request;

import java.net.SocketAddress;

public class AddressRequest {
    private final Request request;
    private final SocketAddress socketAddress;

    public AddressRequest(Request request, SocketAddress socketAddress) {
        this.request = request;
        this.socketAddress = socketAddress;
    }

    public Request getRequest() {
        return request;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }
}
