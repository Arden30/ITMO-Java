package commands;

import collection_Manager.CollectionGenerator;
import collection_Manager.CollectionOfLabWorks;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

import java.util.Scanner;

/**
 * Class, which is responsible for adding new element into the collection
 */
public class Add implements Command{
    private final CollectionOfLabWorks collection;
    private final Scanner sc;
    public Add(CollectionOfLabWorks collection, Scanner sc) {
        this.collection = collection;
        this.sc = sc;
    }
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescr() {
        return ": Adds new element in your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            CollectionGenerator coll = new CollectionGenerator(sc);
            coll.newElement();
            collection.addLabWork(coll.getNewElement());
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Element is successfully added!";
    }
}
