package commands_Handlers;

import commands.Command;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Class, which puts commands in hashmap and invokes them
 */
public class Invoker {
    /**
     * Field, which contains commands in HashMap
     */
    public static final HashMap<String, Command> commands = new HashMap<>();

    public Invoker(Command ...comms) {
        for (Command comm: comms) {
            commands.put(comm.getName(), comm);
        }
    }

    /**
     * Method, which invokes commands from console or script
     * @param command Command which was put in console
     */
    public void invoke(String command) {
        String[] string_command = command.split(" ");
        try {
            String commandName = string_command[0].toLowerCase();
            String[] commandsArgs = Arrays.copyOfRange(string_command, 1, string_command.length);
            if (commands.containsKey(commandName)) {
                Command executingCommand = commands.get(commandName);
                executingCommand.execute(commandsArgs);
            } else {
                System.out.println("No such command!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You entered empty string!");
        }
    }
}
