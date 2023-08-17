package client.util_client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ScriptReader {
    private ArrayList<CommandToSend> commandsFromFile = new ArrayList<>();
    public void readCommandsFromFile(String fileName) throws IOException {
        FileInputStream stream = new FileInputStream(fileName);
        commandsFromFile = streamToArrayOfCommands(stream);
    }

    private ArrayList<CommandToSend> streamToArrayOfCommands(FileInputStream file) throws IOException {
        ArrayList<CommandToSend> commands = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        String line = br.readLine();
        while (line != null) {
            String[] splitInput = line.split(" ");
            String commandName = splitInput[0].toLowerCase();
            String[] commandsArgs = Arrays.copyOfRange(splitInput, 1, splitInput.length);
            commands.add(new CommandToSend(commandName, commandsArgs));
            line = br.readLine();
        }
        br.close();
        return commands;
    }

    public ArrayList<CommandToSend> getCommandsFromFile() {
        return commandsFromFile;
    }
}
