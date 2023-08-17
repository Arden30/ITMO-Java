package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.data_base.DataBaseManager;
import server.util_server.CollectionManager;

import java.util.List;

/**
 * Class, which is responsible for clearing your collection by deleting all the elements
 */
public class Clear extends AbstractClientCommand {
    private final CollectionManager collection;
    private final DataBaseManager dataBaseManager;
    public Clear(CollectionManager collection, DataBaseManager dataBaseManager) {
        super("clear", 0, "clears your collection");
        this.collection = collection;
        this.dataBaseManager = dataBaseManager;
    }
    @Override
    public Response execute(Request request) {
        List<Long> deletedIDs = dataBaseManager.clear(request.getUsername());
        if (deletedIDs.isEmpty()) {
            return new Response("You don't have elements in this collection!");
        } else {
            deletedIDs.forEach(collection::removeByID);
            return new Response("Your elements were removed from the collection, their IDs:" + deletedIDs);
        }
    }
}
