package commands;

/**
 * Basic interface for each command of working with collection
 */
public interface Command {

    /**
     * Method, which returns name of the command
     * @return Name of the command
     */
    String getName();

    /**
     * Method, which returns description of the command
     * @return Description of the command
     */
    String getDescr();

    /**
     * Method, which executes
     * @param commandArgs Args which are entered with a command
     * @return Result of the executing command
     */
    String execute(String[] commandArgs);
}
