package Comparators;

import Person.Person;

public class CompareByName implements PersonComparator {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1 == null || o2 == null) {
            return -1;
        }
        return o1.getName().compareTo(o2.getName());
    }


}
