package common.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class, which keeps LabWorks in the collection
 */
@XStreamAlias("LabWork")
public class LabWork implements Serializable {

    /**
     * Field, which keeps current unique pointer of ID
     */
    private static long currentId = 1;

    /**
     * Field, which keeps ID of element (can't be null, must be positive, unique and automatically generated)
     */
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    /**
     * Field, which keeps name of element (can't be null or empty string)
     */
    private String name; //Поле не может быть null, Строка не может быть пустой

    /**
     * Field, which keeps coordinates of element (can't be null)
     */
    private Coordinates coordinates; //Поле не может быть null

    /**
     * Field, which keeps creation date of element (can't be null and must be automatically generated)
     */
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    /**
     * Field, which keeps minimum points of element (can be null, must be positive)
     */
    private Long minimalPoint; //Поле может быть null, Значение поля должно быть больше 0

    /**
     * Field, which keeps maximum points of element (can be null, must be positive)
     */
    private Integer maximumPoint; //Поле может быть null, Значение поля должно быть больше 0

    /**
     * Field, which keeps personal qualities minimum points of element (can be null, must be positive)
     */
    private Long personalQualitiesMinimum; //Поле может быть null, Значение поля должно быть больше 0

    /**
     * Field, which keeps difficulty of element (can be null)
     */
    private Difficulty difficulty; //Поле может быть null

    /**
     * Field, which keeps discipline of element (can't be null)
     */
    private Discipline discipline; //Поле не может быть null

    /**
     * Basic constructor, which sets unique ID and current creation date
     */
    public LabWork() {
        setId();
        creationDate = LocalDateTime.now();
    }

    /**
     * Getter of ID of the element
     * @return Long ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter of unique ID
     */
    public void setId() {
        this.id = currentId++;
    }

    /**
     * Setter of concrete ID
     * @param id Long ID of the element
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Setter of current creation date
     */
    public void setCreationDate() {
        this.creationDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    /**
     * Getter of name of the element
     * @return String name of the element
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of name of the element
     * @param name String name of the element
     */
    public void setName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("Name can't be null or empty string, try again!");
        } else {
            this.name = name;
        }
    }

    /**
     * Getter of coordinates of the element
     * @return Coordinates of the element
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Setter of coordinates of the element
     * @param coordinates Coordinates of the element
     */
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null)  {
            throw new IllegalArgumentException("Coordinates are needed, try again!");
        }
        this.coordinates = coordinates;
    }

    /**
     * Getter of minimal points of the element
     * @return Long minimal points of the element
     */
    public Long getMinimalPoint() {
        return minimalPoint;
    }

    /**
     * Setter of minimal points of the element
     * @param minimalPoint Long minimal points of the element
     */
    public void setMinimalPoint(Long minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    /**
     * Getter of maximum points of the element
     * @return Integer maximum points of the element
     */
    public Integer getMaximumPoint() {
        return maximumPoint;
    }

    /**
     * Setter of maximum points of the element
     * @param maximumPoint Integer maximum points of the element
     */
    public void setMaximumPoint(Integer maximumPoint) {
        this.maximumPoint = maximumPoint;
    }

    /**
     * Getter of personal qualities minimum points of the element
     * @return Long minimum points of the element
     */
    public Long getPersonalQualitiesMinimum() {
        return personalQualitiesMinimum;
    }

    /**
     * Setter of personal qualities minimum points of the element
     * @param personalQualitiesMinimum Long personal qualities minimal points of the element
     */
    public void setPersonalQualitiesMinimum(Long personalQualitiesMinimum) {
        this.personalQualitiesMinimum = personalQualitiesMinimum;
    }

    /**
     * Getter of difficulty of the element
     * @return Difficulty of the element
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Setter of difficulty of the element
     * @param difficulty Difficulty of the element
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Getter of discipline of the element
     * @return Discipline of the element
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * Setter of discipline of the element
     * @param discipline Discipline of the element
     */
    public void setDiscipline(Discipline discipline) {
        if (discipline == null) {
            throw new IllegalArgumentException("Discipline is needed, try again!");
        } else {
            this.discipline = discipline;
        }
    }

    /**
     * Method, which compares two LabWorks by the length of their names
     * @param lab LabWork for comparison
     * @return Integer number
     */
    public int compareLab(LabWork lab) {
        return Integer.compare(this.name.length(), lab.name.length());
    }

    /**
     * Method, which compares two difficulties of LabWork by the length of their names
     * @param difficulty Difficulty for comparison
     * @return Integer number
     */
    public int compareDifficulty(Difficulty difficulty) {
        return Integer.compare(this.getDifficulty().toString().length(), difficulty.toString().length());
    }

    /**
     * Method, which returns element of collection as a string
     * @return String element of collection
     */
    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates:" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", maximumPoint=" + maximumPoint +
                ", personalQualitiesMinimum=" + personalQualitiesMinimum +
                ", difficulty=" + difficulty +
                ", discipline: " + discipline;
    }
}
