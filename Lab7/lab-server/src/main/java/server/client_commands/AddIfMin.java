package server.client_commands;

import common.data.LabWork;
import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.data_base.DataBaseManager;
import server.util_server.CollectionManager;
import common.exceptions.ElementIsNotMinException;

/**
 * Class, which is responsible for adding new element into the collection if it's minimal
 */
public class AddIfMin extends AbstractClientCommand {
    private final CollectionManager collection;
    private final DataBaseManager dataBaseManager;

    public AddIfMin(CollectionManager collection, DataBaseManager dataBaseManager) {
        super("add_if_min", 0, "adds new element to your collection if it would be minimal in your collection");
        this.collection = collection;
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public Response execute(Request request) {
            if (collection.checkMin(request.getLabArgument())) {
                LabWork labWork = request.getLabArgument();
                Long id = dataBaseManager.addLab(labWork, request.getUsername());
                labWork.setId(id);
                collection.addLabWork(labWork);
                return new Response("New min element was added!", request.getLabArgument());
            } else
                return new Response("Element is not min!");
    }
}
