package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.ElementIsNotMinException;

/**
 * Class, which is responsible for adding new element into the collection if it's minimal
 */
public class AddIfMin extends AbstractClientCommand {
    private final CollectionManager collection;

    public AddIfMin(CollectionManager collection) {
        super("add_if_min", 0, "adds new element to your collection if it would be minimal in your collection");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        try {
            collection.addIfMin(request.getLabArgument());
            return new Response("New element was successfully added!", request.getLabArgument());
        } catch (ElementIsNotMinException e) {
            return new Response(e.getMessage());
        }
    }
}
