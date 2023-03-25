package commands;

import commandsHandlers.CommandsReader;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for exiting from the program
 */
public class Exit implements Command{

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescr() {
        return ": Exits from the program";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            System.out.println("Goodbye!");
            CommandsReader.changeFlag();
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Exit the program";
    }
}
