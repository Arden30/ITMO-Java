package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.NoSuchIDException;

/**
 * Class, which is responsible for updating element of collection by set ID
 */
public class UpdateByID extends AbstractClientCommand {
    private final CollectionManager collection;

    public UpdateByID(CollectionManager collection) {
        super("update", 1, "update the value of a collection item whose id is equal to the specified one", "id");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        try {
            collection.updateByID((Long)request.getNumericArgument(), request.getLabArgument());
            return new Response("Element with ID " + request.getNumericArgument() + " was updated");
        } catch (NoSuchIDException e) {
            return new Response(e.getMessage());
        }
    }
}
