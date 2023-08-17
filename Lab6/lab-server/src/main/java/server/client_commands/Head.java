package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.CollectionIsEmptyException;
import common.exceptions.WrongNumberOfArgsException;


/**
 * Class, which is responsible for printing first element of the collection
 */
public class Head extends AbstractClientCommand {
    private final CollectionManager collection;

    public Head(CollectionManager collection) {
        super("head", 0, "prints first element of your collection");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        try {
            return new Response("First element of collection is: ",collection.head());
        } catch (CollectionIsEmptyException e) {
            return new Response(e.getMessage());
        }
    }
}
