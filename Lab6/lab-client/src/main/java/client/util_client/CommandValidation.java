package client.util_client;

import common.exceptions.WrongArgException;
import common.exceptions.WrongNumberOfArgsException;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class CommandValidation {

    private CommandValidation() {
    }

    public static <T> T validateInput(Predicate<Object> predicate,
                                      String message,
                                      String error,
                                      String wrong,
                                      Function<String, T> function,
                                      Boolean nullable,
                                      Scanner sc) {
        System.out.println(message);
        String input;
        T value;
        do {
            try {
                input = sc.nextLine();
                if ("".equals(input) && Boolean.TRUE.equals(nullable)) {
                    return null;
                } else if ("".equals(input) && !Boolean.TRUE.equals(nullable)) {
                    System.out.println("This field cannot be null, repeat the input");
                    continue;
                }
                value = function.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(error);
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("Invalid character entered");
                System.exit(1);
                return null;
            }
            if (predicate.test(value)) {
                return value;
            } else {
                System.out.println(wrong);
            }
        } while (true);
    }

    public static String validateStringInput(String message,
                                             Boolean nullable,
                                             Scanner sc) {
        System.out.println(message);
        String input;
        do {
            try {
                input = sc.nextLine();
                if ("".equals(input) && Boolean.TRUE.equals(nullable)) {
                    return null;
                } else if ("".equals(input) && !Boolean.TRUE.equals(nullable)) {
                    System.out.println("This field cannot be null, repeat the input");
                    continue;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Invalid character entered");
                System.exit(1);
                return null;
            }
            return input;
        } while (true);
    }
    public static void validateNumberOfArgs(String[] commandArgs, int numberOfArgs) throws WrongNumberOfArgsException {
        if (commandArgs.length != numberOfArgs) {
            throw new WrongNumberOfArgsException("This command requires " + numberOfArgs + " args, try again!");
        }
    }

    public static <T> T validateArg(Predicate<Object> predicate,
                                    String wrong,
                                    Function<String, T> function,
                                    String argument) throws WrongArgException, IllegalArgumentException {
        T value = function.apply(argument);
        if (predicate.test(value)) {
            return value;
        } else {
            throw new WrongArgException(wrong);
        }
    }
}
