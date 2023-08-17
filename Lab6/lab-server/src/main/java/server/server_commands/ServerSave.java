package server.server_commands;

import server.AbstractCommands.AbstractServerCommand;
import server.file_Handlers.FileWriter;
import server.util_server.CollectionManager;

import java.io.IOException;

public class ServerSave extends AbstractServerCommand {
    private final CollectionManager collection;
    private final FileWriter fileWriter;

    public ServerSave(CollectionManager collection, FileWriter fileWriter) {
        super("save", "save the collection to a file");
        this.collection = collection;
        this.fileWriter = fileWriter;
    }

    @Override
    public String execute() {
        try {
            fileWriter.writeToFile(collection);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Collection was successfully saved!";
    }
}
