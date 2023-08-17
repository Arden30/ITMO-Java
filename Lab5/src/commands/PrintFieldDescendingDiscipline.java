package commands;

import collection_Manager.CollectionOfLabWorks;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for printing elements in descending order sorted by the disciplines of LabWorks
 */
public class PrintFieldDescendingDiscipline implements Command{
    private final CollectionOfLabWorks collection;

    public PrintFieldDescendingDiscipline(CollectionOfLabWorks collection) {
        this.collection = collection;
    }

    @Override
    public String getName() {
        return "print_field_descending_discipline";
    }

    @Override
    public String getDescr() {
        return ": Prints values of field 'discipline' in descending order";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            collection.printFieldDescendingDiscipline();
        } catch (WrongNumberOfArgsException | CollectionIsEmptyException e) {
            System.out.println(e.getMessage());
        }
        return "Values of field 'discipline' are printed in descending order!";
    }
}
