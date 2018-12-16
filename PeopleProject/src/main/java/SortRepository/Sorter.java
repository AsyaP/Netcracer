package SortRepository;

import Comparators.PersonComparator;
import Person.Person;

public interface Sorter {

    void sort(Person[]p, PersonComparator c);
}
