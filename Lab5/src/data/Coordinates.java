package data;

/**
 * Class, which keeps coordinates of the elements in the collection
 */
public class Coordinates {

    /**
     * Field, which keeps X coordinate
     */
    private long x; //Максимальное значение поля: 54

    /**
     * Field, which keeps Y coordinate
     */
    private Double y; //Максимальное значение поля: 101, Поле не может быть null

    /**
     * Constant, which keeps maximum values of X coordinate
     */
    private static final long MAX_X = 54;

    /**
     * Constant, which keeps maximum values of Y coordinate
     */
    private static final double MAX_Y = 101;

    /**
     * Getter of X coordinate
     * @return long X coordinate
     */
    public long getX() {
        return this.x;
    }

    /**
     * Setter of X coordinate
     * @param newX long X coordinate
     */
    public void setX(long newX) {
        if (newX > MAX_X) {
            throw new IllegalArgumentException("Value of X coordinate can't exceed 54, try again!");
        } else {
            this.x = newX;
        }
    }

    /**
     * Getter of Y coordinate
     * @return Double Y coordinate
     */
    public Double getY() {
        return this.y;
    }

    /**
     * Setter of Y coordinate
     * @param newY Double Y coordinate
     */
    public void setY(Double newY) {
        if (newY > MAX_Y) {
            throw new IllegalArgumentException("Value of Y coordinate can't exceed 54 or be null, try again!");
        } else {
            this.y = newY;
        }
    }

    /**
     * Method, which returns string line of coordinates
     * @return String line of coordinates
     */
    @Override
    public String toString() {
        return "X=" + x + ", Y=" + y;
    }
}
