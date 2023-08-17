package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.data_base.DataBaseManager;
import server.util_server.CollectionManager;

/**
 * Class, which is responsible for removing element by set ID
 */
public class RemoveByID extends AbstractClientCommand {
    private final CollectionManager collection;
    private final DataBaseManager dataBaseManager;
    public RemoveByID(CollectionManager collection, DataBaseManager dataBaseManager) {
        super("remove", 1, "delete a group from a collection by its id", "id");
        this.collection = collection;
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public Response execute(Request request) {
        if (dataBaseManager.checkID(request.getNumericArgument().longValue(), request.getUsername())) {
            if (dataBaseManager.removeLabByID(request.getNumericArgument().longValue(), request.getUsername())) {
                collection.removeByID(request.getNumericArgument().longValue());
                return new Response("Element with ID " + request.getNumericArgument() + " was removed from the collection!");
            } else {
                return new Response("This is not your element, you can't delete it!");
            }
        } else {
            return new Response("There is no element with such id!");
        }
    }
}
