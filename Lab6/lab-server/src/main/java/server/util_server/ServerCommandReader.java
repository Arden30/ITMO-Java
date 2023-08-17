package server.util_server;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerCommandReader {
    private final Scanner sc;
    public ServerCommandReader(Scanner sc) {
        this.sc = sc;
    }
    public String readCommand() {
        try {
            System.out.println("Enter command(save or exit):");
            return sc.nextLine().trim().toLowerCase();
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
            return null;
        }
    }
}
