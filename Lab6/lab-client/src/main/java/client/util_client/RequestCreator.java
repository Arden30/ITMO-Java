package client.util_client;

import client.CollectionGenerator;
import common.data.Difficulty;
import common.exceptions.WrongArgException;
import common.exceptions.WrongNumberOfArgsException;
import common.util_common.Request;

public class RequestCreator {
    private Request createRequestWithoutArgs(CommandToSend command) {
        try {
            CommandValidation.validateNumberOfArgs(command.getCommandArgs(), 0);
            return new Request(command.getCommandName());
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private Request createRequestWithLab(CommandToSend command) {
        try {
            CommandValidation.validateNumberOfArgs(command.getCommandArgs(), 0);
            CollectionGenerator generator = new CollectionGenerator();
            generator.newElement();
            return new Request(command.getCommandName(), generator.getNewElement());
        } catch (WrongNumberOfArgsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private Request createRequestWithID(CommandToSend command) {
        try {
            CommandValidation.validateNumberOfArgs(command.getCommandArgs(), 1);
            long id = CommandValidation.validateArg(arg -> ((long) arg) > 0,
                    "ID must be greater then 0",
                    Long::parseLong,
                    command.getCommandArgs()[0]);
            return new Request(command.getCommandName(), id);
        } catch (WrongNumberOfArgsException | WrongArgException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong data type of argument");
            return null;
        }
    }

    private Request createRequestWithLabID(CommandToSend command) {
        try {
            CommandValidation.validateNumberOfArgs(command.getCommandArgs(), 1);
            long id = CommandValidation.validateArg(arg -> ((long) arg) > 0,
                    "ID must be greater then 0",
                    Long::parseLong,
                    command.getCommandArgs()[0]);
            CollectionGenerator generator = new CollectionGenerator();
            generator.newElement();
            return new Request(command.getCommandName(), id, generator.getNewElement());
        } catch (WrongNumberOfArgsException | WrongArgException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong data type of argument");
            return null;
        }
    }

    private Request createRequestWithMaxPointArg(CommandToSend command) {
        try {
            CommandValidation.validateNumberOfArgs(command.getCommandArgs(), 1);
            Integer maxPoint = CommandValidation.validateArg(arg -> ((Integer) arg) > 0,
                    "Maximum points must be greater then 0",
                    Integer::parseInt,
                    command.getCommandArgs()[0]);
            return new Request(command.getCommandName(), maxPoint);
        } catch (WrongNumberOfArgsException | WrongArgException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong data type of argument");
            return null;
        }
    }

    private Request createRequestWithDifficultyArg(CommandToSend command) {
        try {
            CommandValidation.validateNumberOfArgs(command.getCommandArgs(), 1);
            Difficulty difficulty = CommandValidation.validateArg(diff -> diff.equals(Difficulty.valueOf(diff.toString())),
                    "Difficulty must be from this list: " + Difficulty.showEnum(),
                    diff -> Difficulty.valueOf(diff.toUpperCase()),
                    command.getCommandArgs()[0]);
            return new Request(command.getCommandName(), difficulty);
        } catch (WrongNumberOfArgsException | WrongArgException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong data type of argument");
            return null;
        }
    }

    public Request createRequestOfCommand(CommandToSend command) {
        String name = command.getCommandName();
        Request request;
        if (AvailableCommands.COMMANDS_WITHOUT_ARGS.contains(name)) {
            request = createRequestWithoutArgs(command);
        } else if (AvailableCommands.COMMANDS_WITH_ID_ARG.contains(name)) {
            request = createRequestWithID(command);
        } else if (AvailableCommands.COMMANDS_WITH_MAXPOINT_ARG.contains(name)) {
            request = createRequestWithMaxPointArg(command);
        } else if (AvailableCommands.COMMANDS_WITH_DIFFICULTY_ARG.contains(name)) {
            request = createRequestWithDifficultyArg(command);
        } else if (AvailableCommands.COMMANDS_WITH_LAB_ARG.contains(name)) {
            request = createRequestWithLab(command);
        } else if (AvailableCommands.COMMANDS_WITH_LAB_ID_ARGS.contains(name)) {
            request = createRequestWithLabID(command);
        } else {
            System.out.println("There is no such command, type HELP to get list on commands");
            request = null;
        }
        return request;
    }

}
