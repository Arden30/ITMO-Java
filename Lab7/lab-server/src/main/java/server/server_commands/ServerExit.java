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
    private final CollectionManager collection;

    public ServerExit(Scanner scanner,CollectionManager collection) {
        super("exit", "shut down the server (you'll be asked to store all the changes)");
        this.scanner = scanner;
        this.collection = collection;
    }

    @Override
    public String execute() {
        ServerConfig.toggleRun();
        return "Server shutdown";
    }
}
