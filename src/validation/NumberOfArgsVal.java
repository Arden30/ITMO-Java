package validation;

import exceptions.WrongNumberOfArgsException;

/**
 * Class, which checks number of args in command
 */
public class NumberOfArgsVal {
    /**
     * Method, which compares given number of args with set number of command
     * @param commandArgs args of the command
     * @param numberOfArgs number of args of the command
     * @throws WrongNumberOfArgsException Exception for the case of wrong number of the args given to a command
     */
    public static void checkNumberOfArgs(String[] commandArgs, int numberOfArgs) throws WrongNumberOfArgsException{
        if (commandArgs.length != numberOfArgs) {
            throw new WrongNumberOfArgsException("This command requires " + numberOfArgs + " args, try again!");
        }
    }
}
