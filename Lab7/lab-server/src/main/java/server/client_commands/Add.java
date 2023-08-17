package server.client_commands;

import common.data.LabWork;
import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.data_base.DataBaseManager;
import server.util_server.CollectionManager;

import java.util.Objects;


/**
 * Class, which is responsible for adding new element into the collection
 */
public class Add extends AbstractClientCommand {
    private final CollectionManager collection;
    private final DataBaseManager dataBaseManager;
    public Add(CollectionManager collection, DataBaseManager dataBaseManager) {
        super("add", 0, "adds new element to the collection");
        this.collection = collection;
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public Response execute(Request request) {
        LabWork labWork = request.getLabArgument();
        Long id = dataBaseManager.addLab(labWork, request.getUsername());
        labWork.setId(id);
        collection.addLabWork(labWork);
        return new Response("New element was added!", request.getLabArgument());

    }
}
