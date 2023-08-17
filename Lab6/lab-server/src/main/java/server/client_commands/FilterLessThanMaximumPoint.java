package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.CollectionIsEmptyException;
import common.exceptions.NoMaxPointsException;
import common.exceptions.WrongNumberOfArgsException;


/**
 * Class, which is responsible for printing elements with less max points than set
 */
public class FilterLessThanMaximumPoint extends AbstractClientCommand {
    private final CollectionManager collection;
    public FilterLessThanMaximumPoint(CollectionManager collection) {
        super("filter_less_than_maximum_point", 1, "Prints elements with less maximum points than entered", "maximum points");
        this.collection = collection;
    }
    @Override
    public Response execute(Request request) {
        try {
            if (collection.filterLessThanMaximumPoint((Integer) request.getNumericArgument()) != null)
                return new Response("Elements with maximum points less than entered are: ", collection.filterLessThanMaximumPoint((Integer) request.getNumericArgument()));
            else
                return new Response("There are no elements with maximum points lower than yours!");
        } catch (CollectionIsEmptyException | NoMaxPointsException e) {
            return new Response(e.getMessage());
        }
    }
}
