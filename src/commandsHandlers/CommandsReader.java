package commandsHandlers;

import commands.*;
import collectionManager.CollectionOfLabWorks;
import data.LabWork;
import fileHandlers.FileWriter;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class, which responsible for reading and executing commands from the console input
 */
public class CommandsReader {

    /**
     * Invoker field
     */
    public static Invoker invoker;

    /**
     * Flag which becomes false in case of exit command
     */
    public static boolean flag = true;

    /**
     * Field, which keeps scanner
     */
    public Scanner sc;

    public CollectionOfLabWorks collection;
    /**
     * Constructor which receives class of the collection and inputs commands in invoker variable
     * @param collection Collection of LabWorks
     * @param sc Scanner
     */
    public CommandsReader(CollectionOfLabWorks collection, Scanner sc) {
        FileWriter writer = new FileWriter();
        this.sc = sc;
        this.collection = collection;
        invoker = new Invoker(new Show(collection),
                new Exit(),
                new Help(Invoker.commands),
                new Info(collection),
                new Clear(collection),
                new Add(collection, sc),
                new RemoveByID(collection),
                new UpdateByID(collection, sc),
                new Save(collection, writer),
                new ExecuteScript(collection),
                new AddIfMin(collection, sc),
                new RemoveLower(collection, sc),
                new FilterLessThanMaximumPoint(collection),
                new FilterGreaterThanDifficulty(collection),
                new PrintFieldDescendingDiscipline(collection),
                new Head(collection));
    }

    /**
     * Method, which changes flag in case of exit command
     */
    public static void changeFlag() {
        flag = false;
    }

    /**
     * Method, which reads commands from the console and calling for their invoking
     */
    public void consoleReader() {
        while (flag) {
            try {
                System.out.println("Enter the command (enter 'help' to see available commands):");
                System.out.print(">");
                String line = sc.nextLine();
                invoker.invoke(line);
            } catch (NoSuchElementException e) {
                System.out.println("Interruption of the program. Shutting down...");
                System.exit(0);
            }
        }
    }

    /**
     * Method, which executes command which has adding of new element in script
     * @param command Name of invoked command
     */
    public void scriptCommandAddReader(String command){
        try {
            invoker.invoke(command);
        } catch (NoSuchElementException e) {
            System.out.println();
            System.out.println("You made a mistake in adding new element in the script. Fix it and try again!");
            System.out.println();
        }
    }
}
