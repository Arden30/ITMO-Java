package commands;

import collectionManager.CollectionOfLabWorks;
import exceptions.CollectionIsEmptyException;
import exceptions.NoMaxPointsException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for printing elements with less max points than set
 */
public class FilterLessThanMaximumPoint implements Command{
    private final CollectionOfLabWorks collection;
    public FilterLessThanMaximumPoint(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "filter_less_than_maximum_point";
    }

    @Override
    public String getDescr() {
        return " maximumPoint: Prints elements with less maximum points that entered";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 1);
            Integer maximumPoint = Integer.parseInt(commandArgs[0]);
            System.out.println("Elements with less maximum points than " + maximumPoint + " are: ");
            collection.filterLessThanMaximumPoint(maximumPoint);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong type of arg, try again!");
        } catch (WrongNumberOfArgsException | CollectionIsEmptyException | NoMaxPointsException e) {
            System.out.println(e.getMessage());
        }
        return "Elements with less maximum points are printed!";
    }
}
