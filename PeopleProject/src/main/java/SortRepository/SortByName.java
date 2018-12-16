package SortRepository;

import Comparators.PersonComparator;
import Person.Person;

public class SortByName implements Sorter {

    @Override
    public void sort(Person[] p, PersonComparator c) {
        int j;
        Person buf;
        for (int i = 0; i < p.length; i++) {
            j = i;

            while (j > 0 && c.compare(p[j - 1], p[j]) >= 1) {
                buf = p[j - 1];
                p[j - 1] = p[j];
                p[j] = buf;
                j -= 1;
            }
        }
    }
}
