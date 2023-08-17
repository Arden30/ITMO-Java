package client.util_client;

import common.exceptions.WrongNumberOfArgsException;
import common.util_common.Request;
import common.util_common.Response;

import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.util.*;

public class ClientStarter {
    private final Scanner scanner = new Scanner(System.in);
    private ClientCommandListener commandListener;
    private final RequestCreator requestCreator = new RequestCreator();
    private ClientSocket clientSocket;
    private boolean statusOfCommandListening = true;
    private static final Set<String> HISTORY_OF_SCRIPTS = new HashSet<>();
    private List<String> user;
    public void startClient() {
        inputAddress();
        inputPort();
        UserRegLog userRegLog = new UserRegLog(clientSocket);
        while (user == null) {
            user = userRegLog.authentication();
        }
        commandListener = new ClientCommandListener(System.in, user.get(0));
        while (statusOfCommandListening) {
            CommandToSend command = commandListener.readCommand();
            if (command != null) {
                if ("exit".equalsIgnoreCase(command.getCommandName())) {
                    System.out.println("Goodbye, " + user.get(0) + "!");
                    toggleStatus();
                } else if (AvailableCommands.SCRIPT_ARGUMENT_COMMAND.equals(command.getCommandName())) {
                    executeScript(command.getCommandArgs());
                } else if (sendRequest(command)) {
                    receiveResponse();
                }
            }
        }
    }
    public void toggleStatus() {
        statusOfCommandListening = !statusOfCommandListening;
    }

    private void inputAddress() {
        System.out.println("Do you want to use a default server address? [y/n]");
        try {
            String s = scanner.nextLine().trim().toLowerCase();
            if ("y".equals(s)) {
                clientSocket = new ClientSocket();
            } else if ("n".equals(s)) {
                System.out.println("Please enter the server's internet address");
                String address = scanner.nextLine();
                clientSocket = new ClientSocket();
                clientSocket.setAddress(address);
            } else {
                System.out.println("You entered not valid symbol, try again");
                inputAddress();
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown address, try again");
            inputAddress();
        } catch (SocketException e) {
            System.out.println("Troubles, while opening server port, try again");
            inputAddress();
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
        }
    }
    private void inputPort() {
        int maxPort = 65535;
        System.out.println("Do you want to use a default port? [y/n]");
        try {
            String s = scanner.nextLine().trim().toLowerCase();
            if ("n".equals(s)) {
                System.out.println("Please enter the remote host port (1-65535)");
                String port = scanner.nextLine();
                try {
                    int portInt = Integer.parseInt(port);
                    if (portInt > 0 && portInt <= maxPort) {
                        clientSocket.setPort(portInt);
                    } else {
                        System.out.println("The number did not fall within the limits, repeat the input");
                        inputPort();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error processing the number, repeat the input");
                    inputPort();
                }
            } else if (!"y".equals(s)) {
                System.out.println("You entered not valid symbol, try again");
                inputPort();
            }
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
        }
    }

    private boolean sendRequest(CommandToSend command) {
        Request request = requestCreator.createRequestOfCommand(command, user.get(0));
        if (request != null) {
            request.setCurrentTime(LocalTime.now());
            request.setClientInfo(clientSocket.getAddress() + " " + clientSocket.getPort());
            request.setUsername(user.get(0));
            request.setPassword(user.get(1));
            try {
                clientSocket.sendRequest(request);
                return true;
            } catch (IOException e) {
                System.out.println("An error occurred while serializing the request, reconnect please");
                System.exit(1);
                return false;
            }
        } else {
            return false;
        }
    }

    private void receiveResponse() {
        try {
            Response response = clientSocket.receiveResponse();
            System.out.println(response.toString());
        } catch (SocketTimeoutException e) {
            System.out.println("The waiting time for a response from the server has been exceeded, try again later");
        } catch (IOException e) {
            System.out.println("An error occurred while receiving a response from the server");
        } catch (ClassNotFoundException e) {
            System.out.println("The response came damaged");
        }
    }
    private void executeScript(String[] args) {
        try {
            CommandValidation.validateNumberOfArgs(args, 1);
            ScriptReader reader = new ScriptReader();
            if (HISTORY_OF_SCRIPTS.contains(args[0])) {
                System.out.println("Possible looping, change your script");
            } else {
                reader.readCommandsFromFile("lab-client/src/main/resources/" + args[0]);
                HISTORY_OF_SCRIPTS.add(args[0]);
                ArrayList<CommandToSend> commands = reader.getCommandsFromFile();
                for (CommandToSend command : commands) {
                    System.out.println("Executing " + command.getCommandName());
                    if ("execute_script".equals(command.getCommandName())) {
                        executeScript(command.getCommandArgs());
                    } else if (sendRequest(command)) {
                        receiveResponse();
                        HISTORY_OF_SCRIPTS.remove(command.getCommandName());
                        }
                    }
                }
        } catch (WrongNumberOfArgsException | IOException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
        }
    }
}
