package collectionManager;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import comparator.DisciplineComparator;
import data.Difficulty;
import data.LabWork;
import exceptions.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Class which keeps your collection of LabWorks and has methods for work with it
 * @author Arsenev Denis
 */
@XStreamAlias("ArrayDeque")
public class CollectionOfLabWorks {

    /**
     *Field, which keeps your collection
     */
    @XStreamImplicit
    private final ArrayDeque<LabWork> collection = new ArrayDeque<>();
    /**
     * Field, which keeps date of initialization of the element in collection
     */
    private LocalDateTime initializationDate;

    /**
     * Field, which keeps name of loaded file with collection
     */
    private String fileName;

    /**
     * Basic constructor, which sets date of initialization and filename
     * @param fileName String mame of file
     */
    public CollectionOfLabWorks(String fileName) {
        this.initializationDate = LocalDateTime.now();
        this.fileName = fileName;
    }

    /**
     * Setter of initialization date
     * @param initializationDate Date of initialization
     */
    public void setInitializationDate(LocalDateTime initializationDate) {
        this.initializationDate = initializationDate;
    }
    /**
     * Getter of collection
     * @return Collection
     */
    public ArrayDeque<LabWork> getCollection() {
        return collection;
    }

    /**
     * Method, which adds new element in collection
     * @param lab New element to add
     */
    public void addLabWork(LabWork lab) {
        collection.add(lab);
    }

    /**
     * Getter of filename
     * @return String name of file
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Setter of filename
     * @param fileName String name of file
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method, which returns type of the collection
     * @return Type of the collection
     */
    public String collectionType() {
        return collection.getClass().getName();
    }

    /**
     * Method, which returns number of elements in the collection
     * @return Int number of elements
     */
    public int collectionSize() {
        return collection.size();
    }

    /**
     * Method, which prints main information about collection
     */
    public void info() {
        System.out.println("Type of collection: " + collectionType() + ",\n" + "Initialization date: " + initializationDate
                + ",\n" + "Amount of elements: " + collectionSize());
    }

    /**
     * Method, which sorts collection by ID of LabWorks
     */
    public void sortByID() {
        List<LabWork> sorted = new ArrayList<>(collection);
        sorted.sort(Comparator.comparingLong(LabWork::getId));
        collection.clear();
        collection.addAll(sorted);
    }
    /**
     * Method, which clears your collection by deleting all the elements
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Method, which prints every element of the collection
     */
    public void show() {
        if (collection.isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            System.out.println("Elements of collection:");
            for (LabWork lab : collection) {
                System.out.println(lab);
            }
        }
    }

    /**
     * Method, which prints first element of the collection
     * @throws CollectionIsEmptyException Exception for the case of empty collection
     */
    public void head() throws CollectionIsEmptyException{
        if (!collection.isEmpty()) {
            System.out.println(collection.getFirst());
        } else {
            throw new CollectionIsEmptyException("Collection is empty!");
        }
    }

    /**
     * Method, which deletes element from the collection by ID
     * @param id ID of the element
     * @throws NoSuchIDException Exception for the case when there is no element with such ID
     */
    public void removeByID(Long id) throws NoSuchIDException {
        for (LabWork lab: collection) {
            if (Objects.equals(lab.getId(), id)) {
                collection.remove(lab);
                return;
            }
        }
        throw new NoSuchIDException("There is no lab with such ID, try again!");
    }

    /**
     * Method, which changes element by chosen ID
     * @param id ID of the element
     * @param lr New element of the collection
     * @throws NoSuchIDException Exception for the case when there is no element with such ID
     */
    public void updateByID(Long id, LabWork lr) throws NoSuchIDException {
        for (LabWork lab: collection) {
            if (Objects.equals(lab.getId(), id)) {
                collection.remove(lab);
                collection.add(lr);
                return;
            }
        }
        throw new NoSuchIDException("There is no lab with such ID, try again!");
    }

    /**
     * Method, which adds new element in the collection if it's lower than others
     * @param lab New element of the collection
     * @throws ElementIsNotMinException Exception for the case if such element is not minimal
     */
    public void AddIfMin(LabWork lab) throws ElementIsNotMinException {
        for (LabWork lr: collection) {
            if (lr.compareLab(lab) <= 0) {
                throw new ElementIsNotMinException("This element is not minimal, try another one!");
            }
        }
        addLabWork(lab);
        System.out.println("Element is added!");
    }

    /**
     * Method, which removes lower element than given
     * @param lab Element for comparison
     * @throws CollectionIsEmptyException Exception for the case of empty collection
     */
    public void removeLower(LabWork lab) throws CollectionIsEmptyException {
        boolean flag = true;
        if (!collection.isEmpty()) {
            for (LabWork lr: collection) {
                if (lr.compareLab(lab) <= 0) {
                    flag = false;
                    collection.remove(lr);
                    System.out.println("Lowest element with ID: " + lr.getId() + " is deleted!");
                }
            }
            if (flag) {
                System.out.println("All elements greater than yours!");
            }
        } else {
            throw new CollectionIsEmptyException("Collection is empty, I can't delete anything!");
        }
    }

    /**
     * Method, which prints elements with less maximum points than given
     * @param maximumPoints Integer number of maximum points
     * @throws CollectionIsEmptyException Exception for the case of empty collection
     * @throws NoMaxPointsException Exception for the case of absence of the element
     */
    public void filterLessThanMaximumPoint(Integer maximumPoints) throws CollectionIsEmptyException, NoMaxPointsException{
        boolean flag = true;
        if (!collection.isEmpty()) {
            for (LabWork lab: collection) {
                if (lab.getMaximumPoint() != null) {
                    if (lab.getMaximumPoint() < maximumPoints) {
                        flag = false;
                        System.out.println(lab);
                    }
                }
                if (flag) {
                    throw new NoMaxPointsException("There are no elements with appropriate maximum points!");
                }
            }
        } else {
            throw new CollectionIsEmptyException("Collection is empty!");
        }
    }

    /**
     * Method, which prints elements with the difficulty greater than given
     * @param difficulty Difficulty of the element for comparison
     * @throws CollectionIsEmptyException Exception for the case of empty collection
     * @throws NoDifficultyException Exception for the case of absence of the difficulty in each element of the collection
     */
    public void filterGreaterThanDifficulty(Difficulty difficulty) throws CollectionIsEmptyException, NoDifficultyException {
        boolean flag1 = true;
        boolean flag2 = true;
        if (!collection.isEmpty()) {
            for (LabWork lab : collection) {
                if (lab.getDifficulty() != null) {
                    flag1 = false;
                    if (lab.compareDifficulty(difficulty) > 0) {
                        flag2 = false;
                        System.out.println(lab);
                    }
                }
            }
            if (flag1) {
                throw new NoDifficultyException("There are no elements with difficulty!");
            }
            if (flag2) {
                System.out.println("There are no elements with difficulty greater than yours!");
            }
        } else {
            throw new CollectionIsEmptyException("Collection is empty!");
        }
    }

    /**
     * Method, which prints elements in descending order comparing them by their disciplines
     * @throws CollectionIsEmptyException Exception for the case of empty collection
     */
    public void printFieldDescendingDiscipline() throws CollectionIsEmptyException{
        if (!collection.isEmpty()) {
            ArrayList<LabWork> sortedLabs = new ArrayList<>(collection);
            sortedLabs.sort((new DisciplineComparator()).reversed());
            for (LabWork lr: sortedLabs) {
                System.out.println(lr.getDiscipline());
            }
        } else {
            throw new CollectionIsEmptyException("Collection is empty!");
        }
    }
}
