package Comparators;

import Person.Person;

public class CompareByDateOfBirth implements PersonComparator {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1 == null || o2 == null) {
            return -1;
        }
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
