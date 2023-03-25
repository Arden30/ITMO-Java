package commands;

import collectionManager.CollectionGenerator;
import collectionManager.CollectionOfLabWorks;
import exceptions.ElementIsNotMinException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

import java.util.Scanner;

/**
 * Class, which is responsible for adding new element into the collection if it's minimal
 */
public class AddIfMin implements Command{
    private final CollectionOfLabWorks collection;
    private final Scanner sc;

    public AddIfMin(CollectionOfLabWorks collection, Scanner sc) {
        this.collection = collection;
        this.sc = sc;
    }

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getDescr() {
        return ": Adds new element in your collection if it would be minimal in your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            CollectionGenerator coll = new CollectionGenerator(sc);
            coll.newElement();
            collection.AddIfMin(coll.getNewElement());
        } catch (WrongNumberOfArgsException | ElementIsNotMinException e) {
            System.out.println(e.getMessage());
        }
        return "Element is successfully added!";
    }
}
