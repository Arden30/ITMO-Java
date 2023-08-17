package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;

/**
 * Class, which is responsible for giving information about current elements in the collection
 */
public class Info extends AbstractClientCommand {

    private final CollectionManager collection;

    public Info(CollectionManager collection) {
        super("info", 0, "displays information about the collection");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        return new Response("Info about collection:\n" + collection.info());
    }
}
