package commands;

import collectionManager.CollectionOfLabWorks;
import exceptions.WrongNumberOfArgsException;
import fileHandlers.FileWriter;
import validation.NumberOfArgsVal;

/**
 * Class, which is responsible for saving your collection into the XML file
 */
public class Save implements Command{
    private final CollectionOfLabWorks collection;
    private final FileWriter writer;
    public Save(CollectionOfLabWorks collection, FileWriter writer) {
        this.collection = collection;
        this.writer = writer;
    }
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescr() {
        return ": Saves your collection in current XML file";
    }

    @Override
    public String execute(String[] commandArgs) {
        try {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 0);
            writer.writeToFile(collection);
            System.out.println("Collection is successfully saved!");
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        }
        return "Collection is successfully saved!";
    }
}
