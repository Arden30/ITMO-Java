package commands;

import collectionManager.CollectionOfLabWorks;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for showing current elements in the collection
 */
public class Show implements Command{
    private final CollectionOfLabWorks collection;
    public Show(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescr() {
        return ": Shows commands which you can execute with your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            collection.show();
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Elements of your collection are here!";
    }
}
