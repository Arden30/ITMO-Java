package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.data_base.DataBaseManager;
import server.util_server.CollectionManager;

/**
 * Class, which is responsible for updating element of collection by set ID
 */
public class UpdateByID extends AbstractClientCommand {
    private final CollectionManager collection;

    private final DataBaseManager dataBaseManager;

    public UpdateByID(CollectionManager collection, DataBaseManager dataBaseManager) {
        super("update", 1, "update the value of a collection item whose id is equal to the specified one", "id");
        this.collection = collection;
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public Response execute(Request request) {
        if (dataBaseManager.checkID(request.getNumericArgument().longValue(), request.getUsername())) {
            if (dataBaseManager.updateLab(request.getLabArgument(), request.getNumericArgument().longValue(), request.getUsername())) {
                collection.updateByID(request.getNumericArgument().longValue(), request.getLabArgument());
                return new Response("Element with ID " + request.getNumericArgument() + " was updated");
            } else {
                return new Response("This is not your element, you can't update it!");
            }
        } else {
            return new Response("There is no element with such id!");
        }
    }
}
