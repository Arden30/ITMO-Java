package commands;

import collection_Manager.CollectionOfLabWorks;
import commands_Handlers.CommandsReader;
import commands_Handlers.Invoker;
import exceptions.WrongNumberOfArgsException;
import validation.NumberOfArgsVal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Class, which is responsible for executing script from entered file
 */
public class ExecuteScript implements Command{
    private static final ArrayDeque<String> history = new ArrayDeque<>();
    private final CollectionOfLabWorks collection;

    public static boolean flag = false;
    public ExecuteScript(CollectionOfLabWorks collection) {
        this.collection = collection;
    }
    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescr() {
        return " file_name: Executes script from entered file";
    }

    @Override
    public String execute(String[] commandArgs) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Z:\\IDEjava\\Lab_5\\src\\resources\\" + commandArgs[0])))) {
            NumberOfArgsVal.checkNumberOfArgs(commandArgs, 1);
            String line = reader.readLine();
            history.add("execute_script " + commandArgs[0]);
            while (line != null) {
                if (history.contains(line)) {
                    System.out.println();
                    System.out.println("There is call of this script in your script, fix it!");
                    line = reader.readLine();
                }
                if (line.contains("execute_script")) {
                    history.add(line);
                }
                if (!"".equals(line.trim())) {
                    System.out.println();
                    System.out.println(line);
                    if ("add".equals(line.trim()) || "add_if_min".equals(line.trim())
                            || line.contains("update") || "remove_lower".equals(line.trim())) {
                        flag = true;
                        StringBuilder list = new StringBuilder();
                        String command;
                        for (int i = 0; i < 10; i++) {
                            command = reader.readLine();
                            if (Invoker.commands.containsKey(command)) {
                                break;
                            }
                            list.append(command + '\n');
                        }
                        Scanner scanner = new Scanner(list.toString());
                        CommandsReader cr = new CommandsReader(collection, scanner);
                        cr.scriptCommandAddReader(line);
                        flag = false;
                    } else {
                        CommandsReader.invoker.invoke(line);
                    }
                    line = reader.readLine();
                }
            }
            history.clear();
            CommandsReader cr2 = new CommandsReader(collection, new Scanner(System.in));
            cr2.consoleReader();
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't find such file!");
        }
        return "Script is executed!";
    }
}
