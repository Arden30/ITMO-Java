package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.util_server.CollectionManager;
import common.exceptions.CollectionIsEmptyException;
import common.exceptions.WrongNumberOfArgsException;

/**
 * Class, which is responsible for printing elements in descending order sorted by the disciplines of LabWorks
 */
public class PrintFieldDescendingDiscipline extends AbstractClientCommand {
    private final CollectionManager collection;

    public PrintFieldDescendingDiscipline(CollectionManager collection) {
        super("print_field_descending_discipline", 0, "Prints values of field 'discipline' in descending order");
        this.collection = collection;
    }

    @Override
    public Response execute(Request request) {
        try {
            return new Response("Disciplines in descending order: ", collection.printFieldDescendingDiscipline());
        } catch (CollectionIsEmptyException e) {
            return new Response(e.getMessage());
        }
    }
}
