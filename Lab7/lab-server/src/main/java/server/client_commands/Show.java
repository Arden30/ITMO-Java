package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;

/**
 * Class, which is responsible for showing current elements in the collection
 */
public class Show extends AbstractClientCommand {
    private final CollectionManager collection;

    public Show(CollectionManager collection) {
        super("show", 0, "displays all the elements of the collection and information about them");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        if (collection.getCollection().isEmpty()) {
            return new Response("Collection is empty");
        } else {
            return new Response("Elements of collection:", collection.getCollection());
        }
    }

}
