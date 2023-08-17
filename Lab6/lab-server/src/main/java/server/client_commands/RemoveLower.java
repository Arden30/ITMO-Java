package server.client_commands;

import common.data.LabWork;
import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.CollectionIsEmptyException;


import java.util.ArrayDeque;

/**
 * Class, which is responsible for removing lower element than set
 */
public class RemoveLower extends AbstractClientCommand {
    private final CollectionManager collection;
    public RemoveLower(CollectionManager collection) {
        super("remove_lower", 1, "Removes element from your collection if it's lower than others", "LabWork");
        this.collection = collection;
    }
    @Override
    public Response execute(Request request) {
        try {
            ArrayDeque<LabWork> res = collection.removeLower(request.getLabArgument());
            if (res.isEmpty()) {
                return new Response("All elements greater, nothing has been deleted");
            } else {
                return new Response("These elements have been removed from the collection:", res);
            }
        } catch (CollectionIsEmptyException e) {
            return new Response(e.getMessage());
        }
    }
}
