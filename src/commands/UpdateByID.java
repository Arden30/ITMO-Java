package commands;

import collectionManager.CollectionGenerator;
import collectionManager.CollectionOfLabWorks;
import comparator.DisciplineComparator;
import data.LabWork;
import exceptions.NoSuchIDException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

import java.util.*;

/**
 * Class, which is responsible for updating element of collection by set ID
 */
public class UpdateByID implements Command{
    private final CollectionOfLabWorks collection;
    private final Scanner sc;
    public UpdateByID(CollectionOfLabWorks collection, Scanner sc) {
        this.collection = collection;
        this.sc = sc;
    }
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescr() {
        return " id: Updates by ID laboratory work from your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 1);
            Long id = Long.parseLong(commandArgs[0]);
            CollectionGenerator col = new CollectionGenerator(id, sc);
            col.newElement();
            collection.updateByID(id, col.getNewElement());
            collection.sortByID();
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number, try again!");
        } catch (WrongNumberOfArgsException | NoSuchIDException e) {
            System.out.println(e.getMessage());
        }
        return "Element by your ID is going to be updated!";
    }
}
