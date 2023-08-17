package server.server_commands;

import server.AbstractCommands.AbstractServerCommand;
import server.file_Handlers.FileWriter;
import server.util_server.CollectionManager;
import server.util_server.ServerConfig;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerExit extends AbstractServerCommand {
    private final Scanner scanner;
    private final FileWriter fileWriter;
    private final CollectionManager collection;

    public ServerExit(Scanner scanner, FileWriter fileWriter, CollectionManager collection) {
        super("exit", "shut down the server (you'll be asked to store all the changes)");
        this.scanner = scanner;
        this.fileWriter = fileWriter;
        this.collection = collection;
    }

    @Override
    public String execute() {
        chooseSaving();
        ServerConfig.toggleRun();
        return "Server shutdown";
    }

    private void chooseSaving() {
        System.out.println("Do you want to save changes? [y/n]");
        try {
            String s = scanner.nextLine().trim().toLowerCase();
            if ("n".equals(s)) {
                System.out.println("Exiting without saving data");
            } else if ("y".equals(s)) {
                fileWriter.writeToFile(collection);
                System.out.println("Collection was successfully saved");
            } else {
                System.out.println("You entered not valid symbol, try again");
                chooseSaving();
            }
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
