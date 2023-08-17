package commands;

import collection_Manager.CollectionOfLabWorks;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for printing first element of the collection
 */
public class Head implements Command{
    private final CollectionOfLabWorks collection;

    public Head(CollectionOfLabWorks collection) {
        this.collection = collection;
    }

    @Override
    public String getName() {
        return "head";
    }

    @Override
    public String getDescr() {
        return ": Prints first element of your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            collection.head();
        } catch (WrongNumberOfArgsException | CollectionIsEmptyException e) {
            System.out.println(e.getMessage());
        }
        return "First element of collection is printed!";
    }
}
