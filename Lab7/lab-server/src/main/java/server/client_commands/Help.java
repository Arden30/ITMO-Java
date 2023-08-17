package server.client_commands;

import common.exceptions.WrongNumberOfArgsException;
import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;


import java.util.HashMap;

/**
 * Class, which is responsible for giving information about available commands
 */
public class Help extends AbstractClientCommand {
    private final HashMap<String, AbstractClientCommand> commands;
    public Help(HashMap<String, AbstractClientCommand> commands) {
        super("help", 0, "helps to see available commands");
        this.commands = commands;
    }
    @Override
    public Response execute(Request request) {
        StringBuilder sb = new StringBuilder();
        for (AbstractClientCommand command : commands.values()) {
            sb.append(command.toString()).append("\n");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        return new Response("Available commands:\n" + sb);
    }
}
