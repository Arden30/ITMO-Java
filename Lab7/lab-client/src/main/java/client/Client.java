package client;

import client.util_client.ClientStarter;


/**
 * Main class of a program
 * @author Arsenev Denis
 */
public class Client {
    public static void main(String[] args) {
        ClientStarter clientWorker = new ClientStarter();
        clientWorker.startClient();
    }
}