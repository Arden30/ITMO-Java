package comparator;

import data.LabWork;

import java.util.Comparator;

/**
 * Special comparator, which gives an instruction how to sort elements by discipline
 */
public class DisciplineComparator implements Comparator<LabWork> {

    /**
     * Method, which compares elements by their disciplines
     * @param first the first object to be compared.
     * @param second the second object to be compared.
     * @return Int number
     */
    @Override
    public int compare(LabWork first, LabWork second) {
        return first.getDiscipline().compareTo(second.getDiscipline());
    }
}
