package server.util_server;

import common.util_common.Request;
import common.util_common.Response;
import server.AbstractCommands.AbstractClientCommand;
import server.AbstractCommands.AbstractServerCommand;


public class CommandManager {
    public CommandManager(AbstractClientCommand Show,
                AbstractClientCommand Exit,
                AbstractClientCommand Help,
                AbstractClientCommand Info,
                AbstractClientCommand Clear,
                AbstractClientCommand Add,
                AbstractClientCommand RemoveByID,
                AbstractClientCommand UpdateByID,
                AbstractClientCommand ExecuteScript,
                AbstractClientCommand AddIfMin,
                AbstractClientCommand RemoveLower,
                AbstractClientCommand FilterLessThanMaximumPoint,
                AbstractClientCommand FilterGreaterThanDifficulty,
                AbstractClientCommand PrintFieldDescendingDiscipline,
                AbstractClientCommand Head,
                AbstractServerCommand ServerExit) {
        ServerConfig.getClientAvailableCommands().put(Show.getName(), Show);
        ServerConfig.getClientAvailableCommands().put(Exit.getName(), Exit);
        ServerConfig.getClientAvailableCommands().put(Help.getName(), Help);
        ServerConfig.getClientAvailableCommands().put(Info.getName(), Info);
        ServerConfig.getClientAvailableCommands().put(Clear.getName(), Clear);
        ServerConfig.getClientAvailableCommands().put(Help.getName(), Help);
        ServerConfig.getClientAvailableCommands().put(Add.getName(), Add);
        ServerConfig.getClientAvailableCommands().put(RemoveByID.getName(), RemoveByID);
        ServerConfig.getClientAvailableCommands().put(UpdateByID.getName(), UpdateByID);
        ServerConfig.getClientAvailableCommands().put(ExecuteScript.getName(), ExecuteScript);
        ServerConfig.getClientAvailableCommands().put(AddIfMin.getName(), AddIfMin);
        ServerConfig.getClientAvailableCommands().put(RemoveLower.getName(), RemoveLower);
        ServerConfig.getClientAvailableCommands().put(FilterLessThanMaximumPoint.getName(), FilterLessThanMaximumPoint);
        ServerConfig.getClientAvailableCommands().put(FilterGreaterThanDifficulty.getName(), FilterGreaterThanDifficulty);
        ServerConfig.getClientAvailableCommands().put(PrintFieldDescendingDiscipline.getName(), PrintFieldDescendingDiscipline);
        ServerConfig.getClientAvailableCommands().put(Head.getName(), Head);
        ServerConfig.getServerAvailableCommands().put(ServerExit.getName(), ServerExit);
    }
    public Response executeClientCommand(Request request) {
        return ServerConfig.getClientAvailableCommands().get(request.getCommandName()).execute(request);
    }

    public String executeServerCommand(String commandName) {
        if (ServerConfig.getServerAvailableCommands().containsKey(commandName)) {
            return ServerConfig.getServerAvailableCommands().get(commandName).execute();
        } else {
            return "There is no such command, type HELP to get list on commands";
        }
    }
}
