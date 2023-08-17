package client.util_client;

import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientCommandListener {
    private final Scanner sc;
    private final String username;

    public ClientCommandListener(InputStream inputStream, String username) {
        this.username = username;
        sc = new Scanner(inputStream);
    }

    public CommandToSend readCommand() {
        try {
            System.out.print("Enter a command: \n" + username + ">");
            String[] splitInput = sc.nextLine().trim().split(" ");
            String commandName = splitInput[0].toLowerCase();
            String[] commandsArgs = Arrays.copyOfRange(splitInput, 1, splitInput.length);
            return new CommandToSend(commandName, commandsArgs);
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
            return null;
        }
    }
}
