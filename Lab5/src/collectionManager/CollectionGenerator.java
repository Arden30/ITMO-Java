package collectionManager;

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
        System.out.println("Enter name of LabWork:");
        System.out.print(">");
        try {
            collection.setName(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newLabName();
        }
    }

    /**
     * Method, which reads and sets new X coordinate
     */
    public void newX() {
        System.out.println("Enter coordinate X:");
        System.out.print(">");
        try {
            coordinates.setX(Long.parseLong(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string, try again!");
            newX();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newX();
        }
    }

    /**
     * Method, which reads and sets new Y coordinate
     */
    public void newY() {
        System.out.println("Enter coordinate Y:");
        System.out.print(">");
        try {
            coordinates.setY(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string, try again!");
            newY();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newY();
        }
    }

    /**
     * Method, which reads and sets new minimal points
     */
    public void newMinPoints() {
        System.out.println("Enter minimal points if you want to set them or just use ENTER:");
        System.out.print(">");
        String minimalPoint = sc.nextLine();
        if ("".equals(minimalPoint)) {
            return;
        }
        try {
            collection.setMinimalPoint(Long.parseLong(minimalPoint));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number, try again!");
            newMinPoints();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newMinPoints();
        }
    }

    /**
     * Method, which reads and sets new maximum points
     */
    public void newMaxPoints() {
        System.out.println("Enter maximum points if you want to set them or just use ENTER:");
        System.out.print(">");
        String maximalPoint = sc.nextLine();
        if ("".equals(maximalPoint)) {
            return;
        }
        try {
            collection.setMaximumPoint(Integer.parseInt(maximalPoint));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number, try again!");
            newMaxPoints();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newMaxPoints();
        }
    }


    /**
     * Method, which reads and sets new personal qualities points
     */
    public void newPersonalQualitiesMinimum() {
        System.out.println("Enter personal qualities points if you want to set them or just use ENTER:");
        System.out.print(">");
        String pqPoint = sc.nextLine();
        if ("".equals(pqPoint)) {
            return;
        }
        try {
            collection.setPersonalQualitiesMinimum(Long.parseLong(pqPoint));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number, try again!");
            newPersonalQualitiesMinimum();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newPersonalQualitiesMinimum();
        }
    }

    /**
     * Method, which reads and sets new difficulty
     */
    public void newDifficulty() {
        System.out.println("Enter one of the difficulty:" + "\n" + Difficulty.showEnum() + "If you don't want to set difficulty just use ENTER:");
        System.out.print(">");
        String diff = sc.nextLine().toUpperCase();
        if ("".equals(diff)) {
            collection.setDifficulty(null);
        } else {
            try {
                collection.setDifficulty(Difficulty.valueOf(diff));
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such difficulty, try again!");
                newDifficulty();
            }
        }
    }

    /**
     * Method, which reads and sets new name of discipline
     */
    public void newDisciplineName() {
        System.out.println("Enter name of discipline:");
        System.out.print(">");
        try {
            discipline.setName(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newDisciplineName();
        }
    }

    /**
     * Method, which reads and sets new lecture hours
     */
    public void newLectureHours() {
        System.out.println("Enter lecture hours:");
        System.out.print(">");
        try {
            discipline.setLectureHours(Long.parseLong(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string, try again!");
            newLectureHours();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newLectureHours();
        }
    }

    /**
     * Method, which reads and sets new practice hours
     */
    public void newPracticeHours() {
        System.out.println("Enter practice hours:");
        System.out.print(">");
        try {
            discipline.setPracticeHours(Long.parseLong(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("I guess you entered not a number or empty string, try again!");
            newPracticeHours();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            newPracticeHours();
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
