package server;

import server.util_server.ServerStarter;

public class Server {
    public static void main(String[] args) {
        if (args.length == 1) {
            ServerStarter server = new ServerStarter(args[0]);
            server.startServer();
        } else {
            System.out.println("Wrong amount of args during entering launch command, you must enter only file name for collection");
            System.exit(1);
        }
    }
}
