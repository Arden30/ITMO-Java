package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;


/**
 * Class, which is responsible for adding new element into the collection
 */
public class Add extends AbstractClientCommand {
    private final CollectionManager collection;
    public Add(CollectionManager collection) {
        super("add", 0, "adds new element to the collection");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        collection.addLabWork(request.getLabArgument());
        return new Response("New element was added!", request.getLabArgument());
    }
}
