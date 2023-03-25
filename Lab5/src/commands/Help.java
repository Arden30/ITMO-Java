package commands;

import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

import java.util.HashMap;

/**
 * Class, which is responsible for giving information about available commands
 */
public class Help implements Command{
    private final HashMap<String, Command> commands;
    public Help(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescr() {
        return ": Helps to see available commands";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            for (Command command : commands.values()) {
                System.out.println(command.getName() + command.getDescr());
            }
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Help information is available now!";
    }
}
