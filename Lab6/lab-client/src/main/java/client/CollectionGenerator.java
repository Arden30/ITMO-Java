package client;

import client.util_client.CommandValidation;
import common.data.Coordinates;
import common.data.Difficulty;
import common.data.Discipline;
import common.data.LabWork;

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
     * Coordinates of a new element
     */
    private final Coordinates coordinates = new Coordinates();

    /**
     * Discipline of a new element
     */
    private final Discipline discipline = new Discipline();

    private Scanner sc = new Scanner(System.in);

    /**
     * Basic constructor with setters of coordinates and disciplines
     */
    public CollectionGenerator() {
        collection.setCoordinates(coordinates);
        collection.setDiscipline(discipline);
    }

    /**
     * Basic constructor with setters of ID, coordinates and disciplines
     * @param id ID of a new element
     */
    public CollectionGenerator(Long id) {
        collection.setId(id);
        collection.setCoordinates(coordinates);
        collection.setDiscipline(discipline);
    }

    /**
     * Method, which reads and sets new name of LabWork
     */
    public void newLabName() {
        String name = CommandValidation.validateStringInput("Enter the name of the lab work: " ,
                false,
                sc);
        collection.setName(name);
    }

    /**
     * Method, which reads and sets new X coordinate
     */
    public void newX() {
        long x = CommandValidation.validateInput(arg -> ((long) arg) <= Coordinates.MAX_X,
                "Enter the X coordinate of the group (its value should be no more than " + Coordinates.MAX_X + ")",
                "Error processing the number, repeat the input",
                "The X coordinate should be no more than " + Coordinates.MAX_X + ", repeat the input",
                Long::parseLong,
                false,
                sc);
        collection.getCoordinates().setX(x);
    }

    /**
     * Method, which reads and sets new Y coordinate
     */
    public void newY() {
        double y = CommandValidation.validateInput(arg -> ((double) arg) <= Coordinates.MAX_Y,
                "Enter the Y coordinate of the group (its value should be no more than " + Coordinates.MAX_Y + ")",
                "Error processing the number, repeat the input",
                "The Y coordinate should be no more than " + Coordinates.MAX_Y + ", repeat the input",
                Double::parseDouble,
                false,
                sc);
        collection.getCoordinates().setY(y);
    }

    /**
     * Method, which reads and sets new minimal points
     */
    public void newMinPoints() {
        Long min = CommandValidation.validateInput(arg -> ((long) arg) > 0,
                "Enter the minimum points of the lab (its value should be positive Long number) or press ENTER to skip",
                "Error processing the number, repeat the input",
                "The minimum points should be positive Long number, repeat the input",
                Long::parseLong,
                true,
                sc);
        collection.setMinimalPoint(min);
    }

    /**
     * Method, which reads and sets new maximum points
     */
    public void newMaxPoints() {
        Integer max = CommandValidation.validateInput(arg -> ((Integer) arg) > 0,
                "Enter the maximum points of the lab (its value should be positive Integer number) or press ENTER to skip",
                "Error processing the number, repeat the input",
                "The maximum points should be positive Integer number, repeat the input",
                Integer::parseInt,
                true,
                sc);
        collection.setMaximumPoint(max);
    }

    /**
     * Method, which reads and sets new personal qualities points
     */
    public void newPersonalQualitiesMinimum() {
        Long pqm = CommandValidation.validateInput(arg -> ((long) arg) > 0,
                "Enter the personal qualities minimum points of the lab (its value should be positive Long number) or press ENTER to skip",
                "Error processing the number, repeat the input",
                "The personal qualities minimum points should be positive Long number, repeat the input",
                Long::parseLong,
                true,
                sc);
        collection.setPersonalQualitiesMinimum(pqm);
    }

    /**
     * Method, which reads and sets new difficulty
     */
    public void newDifficulty() {
        Difficulty diff = CommandValidation.validateInput(arg -> true,
                "Enter the difficulty of the lab from the suggested ones below (press ENTER to skip)\n" + Difficulty.showEnum(),
                "There is no such difficulty, repeat the input",
                "Input error",
                difficulty -> Difficulty.valueOf(difficulty.toUpperCase()),
                true,
                sc);
        collection.setDifficulty(diff);
    }

    /**
     * Method, which reads and sets new name of discipline
     */
    public void newDisciplineName() {
        String name = CommandValidation.validateStringInput("Enter the name of the lab work: " ,
                false,
                sc);
        discipline.setName(name);
    }

    /**
     * Method, which reads and sets new lecture hours
     */
    public void newLectureHours() {
        Long lecHours = CommandValidation.validateInput(arg -> ((long) arg) > 0,
                "Enter the lecture hours of the discipline (its value should be positive Long number)",
                "Error processing the number, repeat the input",
                "The lecture hours of the discipline should be positive Long number",
                Long::parseLong,
                false,
                sc);
        discipline.setLectureHours(lecHours);
    }

    /**
     * Method, which reads and sets new practice hours
     */
    public void newPracticeHours() {
        Long practiceHours = CommandValidation.validateInput(arg -> ((long) arg) > 0,
                "Enter the practice hours of the discipline (its value should be positive Long number)",
                "Error processing the number, repeat the input",
                "The lecture hours of the discipline should be positive Long number",
                Long::parseLong,
                false,
                sc);
        discipline.setPracticeHours(practiceHours);
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
        return collection;
    }
}
