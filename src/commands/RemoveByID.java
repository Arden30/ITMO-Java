package commands;

import collectionManager.CollectionOfLabWorks;
import exceptions.NoSuchIDException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for removing element by set ID
 */
public class RemoveByID implements Command{
    private final CollectionOfLabWorks collection;
    public RemoveByID(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescr() {
        return " id: Removes by ID laboratory work from your collection";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 1);
            Long id = Long.parseLong(commandArgs[0]);
            collection.removeByID(id);
            System.out.println("Element by your ID is removed!");
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number, try again!");
        } catch (WrongNumberOfArgsException | NoSuchIDException e) {
            System.out.println(e.getMessage());
        }
        return "Element by your ID is removed!";
    }
}
