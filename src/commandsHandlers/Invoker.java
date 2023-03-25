package commandsHandlers;

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

    public Invoker(Command Show, Command Exit, Command Help, Command Info, Command Clear, Command Add, Command RemoveByID,
                   Command UpdateByID, Command Save, Command ExecuteScript, Command AddIfMin, Command RemoveLower,
                   Command FilterLessThanMaxPoint, Command FilterGreaterThanDifficulty, Command PrintFieldDescendingOrder, Command Head) {
        commands.put(Help.getName(), Help);
        commands.put(Show.getName(), Show);
        commands.put(Exit.getName(), Exit);
        commands.put(Info.getName(), Info);
        commands.put(Clear.getName(), Clear);
        commands.put(Add.getName(), Add);
        commands.put(RemoveByID.getName(), RemoveByID);
        commands.put(UpdateByID.getName(), UpdateByID);
        commands.put(Save.getName(), Save);
        commands.put(ExecuteScript.getName(), ExecuteScript);
        commands.put(AddIfMin.getName(), AddIfMin);
        commands.put(RemoveLower.getName(), RemoveLower);
        commands.put(FilterLessThanMaxPoint.getName(), FilterLessThanMaxPoint);
        commands.put(FilterGreaterThanDifficulty.getName(), FilterGreaterThanDifficulty);
        commands.put(PrintFieldDescendingOrder.getName(), PrintFieldDescendingOrder);
        commands.put(Head.getName(), Head);
    }

    /**
     * Method, which invokes commands from console or script
     * @param command
     */
    public void invoke(String command) {
        String[] string_command = command.split(" ");
        String commandName = string_command[0].toLowerCase();
        String[] commandsArgs = Arrays.copyOfRange(string_command, 1, string_command.length);
        if (commands.containsKey(commandName)) {
            Command executingCommand = commands.get(commandName);
            executingCommand.execute(commandsArgs);
        } else {
            System.out.println("No such command!");
        }
    }
}
