package server.util_server;

import server.AbstractCommands.AbstractClientCommand;
import server.AbstractCommands.AbstractServerCommand;

import java.util.HashMap;

public class ServerConfig {
    private static final HashMap<String, AbstractClientCommand> CLIENT_AVAILABLE_COMMANDS = new HashMap<>();
    private static final HashMap<String, AbstractServerCommand> SERVER_AVAILABLE_COMMANDS = new HashMap<>();
    private static boolean isRunning = true;

    private ServerConfig() {
    }

    public static boolean getRunning() {
        return isRunning;
    }

    public static void toggleRun() {
        isRunning = !isRunning;
    }

    public static HashMap<String, AbstractClientCommand> getClientAvailableCommands() {
        return CLIENT_AVAILABLE_COMMANDS;
    }

    public static HashMap<String, AbstractServerCommand> getServerAvailableCommands() {
        return SERVER_AVAILABLE_COMMANDS;
    }

}
