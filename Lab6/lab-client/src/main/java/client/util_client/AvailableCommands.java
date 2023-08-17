package client.util_client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AvailableCommands {
    public static final Set<String> COMMANDS_WITHOUT_ARGS = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_ID_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_MAXPOINT_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_DIFFICULTY_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_LAB_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_LAB_ID_ARGS = new HashSet<>();
    public static final String SCRIPT_ARGUMENT_COMMAND;

    static {
        Collections.addAll(COMMANDS_WITHOUT_ARGS,
                "help",
                "show",
                "info",
                "clear",
                "head",
                "print_field_descending_discipline"
        );
        Collections.addAll(COMMANDS_WITH_ID_ARG,
                "remove_by_id"
        );
        Collections.addAll(COMMANDS_WITH_MAXPOINT_ARG,
                "filter_less_than_maximum_point"
        );
        Collections.addAll(COMMANDS_WITH_DIFFICULTY_ARG,
                "filter_greater_than_difficulty"
        );
        Collections.addAll(COMMANDS_WITH_LAB_ARG,
                "add",
                "add_if_min",
                "remove_lower"
        );
        Collections.addAll(COMMANDS_WITH_LAB_ID_ARGS,
                "update");

        SCRIPT_ARGUMENT_COMMAND = "execute_script";
    }

    private AvailableCommands() {
    }
}
