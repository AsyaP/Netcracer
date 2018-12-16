package Tests;

import Comparators.CompareByDateOfBirth;
import Comparators.CompareByGender;
import Comparators.CompareByName;
import Person.Person;
import SortRepository.Sorter;
import SortRepository.SortByDateOfBirth;
import SortRepository.SortByGender;
import SortRepository.SortByName;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    Person[] person;

    @BeforeEach
    void before() {
        person = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w")
        };
    }

    @Test
    void sortByDateOfBirth() {
        Sorter sorter = new SortByDateOfBirth();
        Person[] expected = new Person[]{
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m"),
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w")

        };
        sorter.sort(person, new CompareByDateOfBirth());
        Person[] actual = person;
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortByGender() {
        Sorter sorter = new SortByGender();
        Person[] expected = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m"),
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w")
        };
        sorter.sort(person, new CompareByGender());
        Person[] actual = person;
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortByName() {
        Sorter sorter = new SortByName();
        Person[] expected = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m")
        };
        sorter.sort(person, new CompareByName());
        Person[] actual = person;
        assertArrayEquals(expected, actual);
    }
}
