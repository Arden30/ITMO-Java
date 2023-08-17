package collection_Manager;

import commands.ExecuteScript;
import data.Coordinates;
import data.Difficulty;
import data.Discipline;
import data.LabWork;

import java.util.Scanner;

/**
 * Class, which generates new element for the collection
 */
public class CollectionGenerator {

    /**
     * New element for collection (LabWork)
     */
    private final LabWork collection = new LabWork();

    /**
     * Scanner for reading characteristics of a new element
     */
    private final Scanner sc;

    /**
     * Coordinates of a new element
     */
    private final Coordinates coordinates = new Coordinates();

    /**
     * Discipline of a new element
     */
    private final Discipline discipline = new Discipline();

    /**
     * Basic constructor with setters of coordinates and disciplines
     */
    public CollectionGenerator(Scanner sc) {
        this.sc = sc;
        collection.setCoordinates(coordinates);
        collection.setDiscipline(discipline);
    }

    /**
     * Basic constructor with setters of ID, coordinates and disciplines
     * @param id ID of a new element
     */
    public CollectionGenerator(Long id, Scanner sc) {
        this.sc = sc;
        collection.setId(id);
        collection.setCoordinates(coordinates);
        collection.setDiscipline(discipline);
    }

    /**
     * Method, which reads and sets new name of LabWork
     */
    public void newLabName() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter name of LabWork:");
            System.out.print(">");
        }
        try {
            collection.setName(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newLabName();
            }
        }
    }

    /**
     * Method, which reads and sets new X coordinate
     */
    public void newX() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter coordinate X:");
            System.out.print(">");
        }
        try {
            coordinates.setX(Long.parseLong(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string in X coordinate, try again!");
            if (!ExecuteScript.flag) {
                newX();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newX();
            }
        }
    }

    /**
     * Method, which reads and sets new Y coordinate
     */
    public void newY() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter coordinate Y:");
            System.out.print(">");
        }
        try {
            coordinates.setY(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string in Y coordinate, try again!");
            if (!ExecuteScript.flag) {
                newY();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newY();
            }
        }
    }

    /**
     * Method, which reads and sets new minimal points
     */
    public void newMinPoints() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter minimal points if you want to set them or just use ENTER:");
            System.out.print(">");
        }
        String minimalPoint = sc.nextLine();
        if ("".equals(minimalPoint)) {
            return;
        }
        try {
            collection.setMinimalPoint(Long.parseLong(minimalPoint));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number in min points, try again!");
            if (!ExecuteScript.flag) {
                newMinPoints();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newMinPoints();
            }
        }
    }

    /**
     * Method, which reads and sets new maximum points
     */
    public void newMaxPoints() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter maximum points if you want to set them or just use ENTER:");
            System.out.print(">");
        }
        String maximalPoint = sc.nextLine();
        if ("".equals(maximalPoint)) {
            return;
        }
        try {
            collection.setMaximumPoint(Integer.parseInt(maximalPoint));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number in max points, try again!");
            if (!ExecuteScript.flag) {
                newMaxPoints();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newMaxPoints();
            }
        }
    }

    /**
     * Method, which reads and sets new personal qualities points
     */
    public void newPersonalQualitiesMinimum() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter personal qualities points if you want to set them or just use ENTER:");
            System.out.print(">");
        }
        String pqPoint = sc.nextLine();
        if ("".equals(pqPoint)) {
            return;
        }
        try {
            collection.setPersonalQualitiesMinimum(Long.parseLong(pqPoint));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number in personal min qualities, try again!");
            if (!ExecuteScript.flag) {
                newPersonalQualitiesMinimum();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newPersonalQualitiesMinimum();
            }
        }
    }

    /**
     * Method, which reads and sets new difficulty
     */
    public void newDifficulty() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter one of the difficulty:" + "\n" + Difficulty.showEnum() + "If you don't want to set difficulty just use ENTER:");
            System.out.print(">");
        }
        String diff = sc.nextLine().toUpperCase();
        if ("".equals(diff)) {
            collection.setDifficulty(null);
        } else {
            try {
                collection.setDifficulty(Difficulty.valueOf(diff));
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such difficulty, try again!");
                if (!ExecuteScript.flag) {
                    newDifficulty();
                }
            }
        }
    }

    /**
     * Method, which reads and sets new name of discipline
     */
    public void newDisciplineName() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter name of discipline:");
            System.out.print(">");
        }
        try {
            discipline.setName(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newDisciplineName();
            }
        }
    }

    /**
     * Method, which reads and sets new lecture hours
     */
    public void newLectureHours() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter lecture hours:");
            System.out.print(">");
        }
        try {
            discipline.setLectureHours(Long.parseLong(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string in lecture hours, try again!");
            if (!ExecuteScript.flag) {
                newLectureHours();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newLectureHours();
            }
        }
    }

    /**
     * Method, which reads and sets new practice hours
     */
    public void newPracticeHours() {
        if (!ExecuteScript.flag) {
            System.out.println("Enter practice hours:");
            System.out.print(">");
        }
        try {
            discipline.setPracticeHours(Long.parseLong(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string in practice hours, try again!");
            if (!ExecuteScript.flag) {
                newPracticeHours();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!ExecuteScript.flag) {
                newPracticeHours();
            }
        }
    }

    /**
     * Method, which reads and sets new values of variables for the element of collection
     */
    public void newElement() {
        newLabName();
        newX();
        newY();
        newMinPoints();
        newMaxPoints();
        newPersonalQualitiesMinimum();
        newDifficulty();
        newDisciplineName();
        newLectureHours();
        newPracticeHours();
    }

    /**
     * Method, which returns and prints new element of the collection
     * @return New element of the collection
     */
    public LabWork getNewElement() {
        System.out.println(collection);
        return collection;
    }
}
