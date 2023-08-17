package common.util_common;

import common.data.Difficulty;
import common.data.LabWork;

import java.io.Serializable;
import java.time.LocalTime;

public class Request implements Serializable {
    private final String commandName;
    private String clientInfo;
    private LocalTime currentTime;
    private Number numericArgument;
    private LabWork labArgument;
    private Difficulty diff;

    public Request(String commandName) {
        this.commandName = commandName;
    }

    public Request(String commandName, Number numericArgument) {
        this.commandName = commandName;
        this.numericArgument = numericArgument;
    }
    public Request(String commandName, Difficulty diff) {
        this.commandName = commandName;
        this.diff = diff;
    }
    public Request(String commandName, LabWork labArgument) {
        this.commandName = commandName;
        this.labArgument = labArgument;
    }

    public Request(String commandName, Number numericArgument, LabWork labArgument) {
        this.commandName = commandName;
        this.numericArgument = numericArgument;
        this.labArgument = labArgument;
    }

    public String getCommandName() {
        return commandName;
    }

    public Number getNumericArgument() {
        return numericArgument;
    }

    public LabWork getLabArgument() {
        return labArgument;
    }

    public Difficulty getDifficultyArgument() { return diff; }

    public String getClientInfo() {
        return clientInfo;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "Name of command to send: " + commandName
                + (labArgument == null ? "" : "\nInfo about lab to send: " + labArgument)
                + (numericArgument == null ? "" : "\nNumeric argument to send: " + numericArgument);
    }
}
