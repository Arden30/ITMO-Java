package server.client_commands;


import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.CollectionIsEmptyException;
import common.exceptions.NoDifficultyException;

/**
 * Class, which is responsible for printing elements with greater difficulty than set
 */
public class FilterGreaterThanDifficulty extends AbstractClientCommand {
    private final CollectionManager collection;
    public FilterGreaterThanDifficulty(CollectionManager collection) {
        super("filter_greater_than_difficulty", 1, "prints elements with greater difficulty than entered", "difficulty");
        this.collection = collection;
    }
    @Override
    public Response execute(Request request) {
        try {
            if (collection.filterGreaterThanDifficulty(request.getDifficultyArgument()) != null)
                return new Response("Elements with difficulty greater than entered are: ", collection.filterGreaterThanDifficulty(request.getDifficultyArgument()));
            else
                return new Response("There are no elements with difficulty greater than yours!");
        } catch (CollectionIsEmptyException | NoDifficultyException e) {
            return new Response(e.getMessage());
        }
    }
}
