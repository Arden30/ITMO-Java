package server.AbstractCommands;

public abstract class AbstractServerCommand {
    private final String name;
    private final String description;

    public AbstractServerCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract String execute();

    @Override
    public String toString() {
        return "Name of command: " + name + ", description: " + description;
    }
}
