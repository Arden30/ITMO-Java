package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;

/**
 * Class, which is responsible for clearing your collection by deleting all the elements
 */
public class Clear extends AbstractClientCommand {
    private final CollectionManager collection;
    public Clear(CollectionManager collection) {
        super("clear", 0, "clears your collection");
        this.collection = collection;
    }
    @Override
    public Response execute(Request request) {
        if (collection.getCollection().isEmpty()) {
            return new Response("Collection is already empty");
        } else {
            collection.clear();
            return new Response("The collection has been cleared");
        }
    }
}
