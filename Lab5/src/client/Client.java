package client;

import commandsHandlers.CommandsReader;
import fileHandlers.FileReader;
import collectionManager.CollectionOfLabWorks;

import java.util.Scanner;


/**
 * Main class of a program
 * @author Arsenev Denis
 */
public class Client {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        CollectionOfLabWorks collection = fileReader.readFile(args[0]);
        CommandsReader cr = new CommandsReader(collection, new Scanner(System.in));
        cr.consoleReader();
    }
}