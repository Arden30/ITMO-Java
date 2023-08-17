package commands;

import collection_Manager.CollectionGenerator;
import collection_Manager.CollectionOfLabWorks;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

import java.util.Scanner;

/**
 * Class, which is responsible for removing lower element than set
 */
public class RemoveLower implements Command{
    private final CollectionOfLabWorks collection;
    private final Scanner sc;
    public RemoveLower(CollectionOfLabWorks collection, Scanner sc) {
        this.collection = collection;
        this.sc = sc;
    }
    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescr() {
        return ": Removes element from your collection if it's lower than others";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            CollectionGenerator coll = new CollectionGenerator(sc);
            coll.newElement();
            collection.removeLower(coll.getNewElement());
        } catch (WrongNumberOfArgsException | CollectionIsEmptyException e) {
            System.out.println(e.getMessage());
        }
        return "Element is successfully removed!";
    }
}
