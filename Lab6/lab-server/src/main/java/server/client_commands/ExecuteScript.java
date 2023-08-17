package server.client_commands;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;

import java.util.HashSet;
import java.util.Set;

/**
 * Class, which is responsible for executing script from entered file
 */
public class ExecuteScript extends AbstractClientCommand {

    public ExecuteScript() {
        super("execute_script", 1, "read and execute the script from the specified file", "file name");
    }

    @Override
    public Response execute(Request request) {
        return null;
    }
}
