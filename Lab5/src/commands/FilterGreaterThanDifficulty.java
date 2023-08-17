package commands;

import collection_Manager.CollectionOfLabWorks;
import data.Difficulty;
import exceptions.CollectionIsEmptyException;
import exceptions.NoDifficultyException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for printing elements with greater difficulty than set
 */
public class FilterGreaterThanDifficulty implements Command{
    private final CollectionOfLabWorks collection;
    public FilterGreaterThanDifficulty(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "filter_greater_than_difficulty";
    }

    @Override
    public String getDescr() {
        return " difficulty: Prints elements with greater difficulty that entered";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 1);
            System.out.println("Elements with greater difficulty than " + Difficulty.valueOf(commandArgs[0].toUpperCase()) + " are: ");
            collection.filterGreaterThanDifficulty(Difficulty.valueOf(commandArgs[0].toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong type of arg, try again!");
        } catch (WrongNumberOfArgsException | CollectionIsEmptyException | NoDifficultyException e) {
            System.out.println(e.getMessage());
        }
        return "Elements with greater difficulty are printed!";
    }
}
