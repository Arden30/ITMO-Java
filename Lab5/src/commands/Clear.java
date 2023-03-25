package commands;

import collectionManager.CollectionOfLabWorks;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for clearing your collection by deleting all the elements
 */
public class Clear implements Command{
    private final CollectionOfLabWorks collection;
    public Clear(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescr() {
        return ": Clears your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            collection.clear();
            System.out.println("Collection is cleared!");
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Collection is successfully cleared!";
    }
}
