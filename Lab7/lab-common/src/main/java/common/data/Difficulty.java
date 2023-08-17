package common.data;

import java.io.Serializable;

/**
 * Enum, which keeps possible difficulties of LabWork
 */
public enum Difficulty implements Serializable {
    EASY,
    VERY_HARD,
    HOPELESS,
    TERRIBLE;

    /**
     * Method, which returns enum as a string
     * @return String enum
     */
    public static String showEnum() {
        StringBuilder sb = new StringBuilder();
        for (Difficulty diff : values()) {
            sb.append(diff);
            sb.append("\n");
        }
        return sb.toString();
    }
}
