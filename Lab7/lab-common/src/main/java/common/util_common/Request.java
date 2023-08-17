package common.util_common;

import common.data.Difficulty;
import common.data.LabWork;

import java.io.Serializable;
import java.time.LocalTime;

public class Request implements Serializable {
    private String commandName;
    private String clientInfo;
    private LocalTime currentTime;
    private Number numericArgument;
    private LabWork labArgument;
    private Difficulty diff;

    private String username;
    private String password;
    private final RequestType requestType;

    public Request(String username, String password, RequestType requestType) {
        this.requestType = requestType;
        this.password = password;
        this.username = username;
    }
    public Request(String commandName, RequestType requestType) {
        this.commandName = commandName;
        this.requestType = requestType;
    }

    public Request(String commandName, Number numericArgument, RequestType requestType) {
        this.commandName = commandName;
        this.numericArgument = numericArgument;
        this.requestType = requestType;
    }
    public Request(String commandName, Difficulty diff, RequestType requestType) {
        this.commandName = commandName;
        this.diff = diff;
        this.requestType = requestType;
    }
    public Request(String commandName, LabWork labArgument, RequestType requestType) {
        this.commandName = commandName;
        this.labArgument = labArgument;
        this.requestType = requestType;
    }

    public Request(String commandName, Number numericArgument, LabWork labArgument, RequestType requestType) {
        this.commandName = commandName;
        this.numericArgument = numericArgument;
        this.labArgument = labArgument;
        this.requestType = requestType;
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

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public String toString() {
        if (requestType.equals(RequestType.REGISTER)) {
            return "Register request";
        }
        else  if (requestType.equals(RequestType.LOGIN)) {
            return "Login request";
        }
        return "Name of command to send: " + commandName
                + (labArgument == null ? "" : "\nInfo about lab to send: " + labArgument)
                + (numericArgument == null ? "" : "\nNumeric argument to send: " + numericArgument);
    }
}
