package client;

import commands_Handlers.CommandsReader;
import file_Handlers.FileReader;
import collection_Manager.CollectionOfLabWorks;

import java.util.Scanner;


/**
 * Main class of a program
 * @author Arsenev Denis
 */
public class Client {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        try {
            CollectionOfLabWorks collection = fileReader.readFile(args[0]);
            CommandsReader cr = new CommandsReader(collection, new Scanner(System.in));
            cr.consoleReader();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You didn't enter file!");
        }
    }
}