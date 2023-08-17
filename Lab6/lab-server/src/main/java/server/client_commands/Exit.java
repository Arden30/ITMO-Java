package server.client_commands;


import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;


/**
 * Class, which is responsible for exiting from the program
 */
public class Exit extends AbstractClientCommand {
    public Exit() {
        super("exit", 0, "shut down the client (all your changes will be lost)");
    }
    @Override
    public Response execute(Request request) {
        return null;
    }
}
