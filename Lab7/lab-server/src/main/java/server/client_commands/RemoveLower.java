package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.data_base.DataBaseManager;
import server.util_server.CollectionManager;


import java.util.ArrayList;
import java.util.List;

/**
 * Class, which is responsible for removing lower element than set
 */
public class RemoveLower extends AbstractClientCommand {
    private final CollectionManager collection;
    private final DataBaseManager dataBaseManager;
    public RemoveLower(CollectionManager collection, DataBaseManager dataBaseManager) {
        super("remove_lower", 1, "Removes element from your collection if it's lower than others", "LabWork");
        this.collection = collection;
        this.dataBaseManager = dataBaseManager;
    }
    @Override
    public Response execute(Request request) {
        List<Long> ids = collection.returnIDsOfLower(request.getLabArgument());
        if (ids.isEmpty()) {
            return new Response("All element greater than yours!");
        } else {
            List<Long> removedIDs = new ArrayList<>();
            for (Long id: ids) {
                if (dataBaseManager.removeLabByID(id, request.getUsername())) {
                    removedIDs.add(id);
                    collection.removeByID(id);
                }
            }
            if (removedIDs.isEmpty()) {
                return new Response("All element greater than yours, you can't delete other users elements!");
            } else {
                return new Response("Elements that are lower with ids: " + removedIDs + " were removed!");
            }
        }
    }
}
