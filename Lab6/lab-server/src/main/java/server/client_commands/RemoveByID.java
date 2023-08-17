package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.NoSuchIDException;

/**
 * Class, which is responsible for removing element by set ID
 */
public class RemoveByID extends AbstractClientCommand {
    private final CollectionManager collection;
    public RemoveByID(CollectionManager collection) {
        super("remove_by_id", 1, "delete a group from a collection by its id", "id");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        try {
            collection.removeByID((Long) request.getNumericArgument());
            return new Response("LabWork with ID " + request.getNumericArgument() + " was deleted from collection");
        } catch (NoSuchIDException e) {
            return new Response(e.getMessage());
        }
    }
}
