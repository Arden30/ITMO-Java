package server;

import server.util_server.ServerStarter;

public class Server {
    public static void main(String[] args) {
        ServerStarter server = new ServerStarter();
        server.startServer();
    }
}
