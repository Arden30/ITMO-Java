package commands;

import collection_Manager.CollectionOfLabWorks;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for giving information about current elements in the collection
 */
public class Info implements Command{
    private final CollectionOfLabWorks collection;
    public Info(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescr() {
        return ": Shows type of collection, initialization date, amount of elements";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            collection.info();
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Information about collection is available now!";
    }
}
