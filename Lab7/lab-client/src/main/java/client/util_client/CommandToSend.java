package client.util_client;

public class CommandToSend {
    private String commandName;
    private String[] commandArgs;

    public CommandToSend(String commandName, String[] commandArgs) {
        this.commandName = commandName;
        this.commandArgs = commandArgs;
    }

    public String getCommandName() {
        return commandName;
    }

    public String[] getCommandArgs() {
        return commandArgs;
    }
}
