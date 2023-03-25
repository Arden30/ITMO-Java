package data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Class, which keeps disciplines in the collection
 */
@XStreamAlias("discipline")
public class Discipline {

    /**
     * Field, which keeps name of discipline (can't be null or empty string)
     */
    private String name; //Поле не может быть null, Строка не может быть пустой

    /**
     * Field, which keeps lecture hours of discipline (can't be null)
     */
    private Long lectureHours; //Поле не может быть null

    /**
     * Field, which keeps practice hours of discipline (can't be null)
     */
    private Long practiceHours; //Поле не может быть null

    /**
     * Getter of a name of discipline
     * @return String name of discipline
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of a name of discipline
     * @param name String name of discipline
     */
    public void setName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("Name can't be null or empty string, try again!");
        } else {
            this.name = name;
        }
    }

    /**
     * Getter of lecture hours of discipline
     * @return long lecture hours of discipline
     */
    public long getLectureHours() {
        return lectureHours;
    }

    /**
     * Setter of lecture hours of discipline
     * @param lectureHours Long lecture hours of discipline
     */
    public void setLectureHours(Long lectureHours) {
        if (lectureHours < 0) {
            throw new IllegalArgumentException("Lecture Hours can't be negative, try again!");
        } else {
            this.lectureHours = lectureHours;
        }
    }

    /**
     * Getter of practice hours of discipline
     * @return long practice hours of discipline
     */
    public long getPracticeHours() {
        return practiceHours;
    }

    /**
     * Setter of practice hours of discipline
     * @param practiceHours Long lecture hours of discipline
     */
    public void setPracticeHours(Long practiceHours) {
        if (practiceHours < 0) {
            throw new IllegalArgumentException("Practice Hours can't be negative, try again!");
        } else {
            this.practiceHours = practiceHours;
        }
    }

    /**
     * Method, which compares two disciplines by lecture hours
     * @param discipline Discipline for comparison
     * @return Int number
     */
    public int compareTo(Discipline discipline) {
        return this.lectureHours.compareTo(discipline.getLectureHours());
    }

    /**
     * Method, which returns discipline with characteristics as a string
     * @return String discipline
     */
    @Override
    public String toString() {
        return "Discipline{" + "name='" + name + '\'' + ',' +
                " lectureHours=" + lectureHours + ',' +
                " practiceHours=" + practiceHours + "}";
    }
}
