package Tests;

import Person.Person;
import Repository.Repository;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository;

    @BeforeEach
    void makeRepository() {
        repository = new Repository();
        repository.add(new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"));
        repository.add(new Person(2, "Jane", new LocalDate(1995,11,2), "w"));
        repository.add(new Person(3,"Max", new LocalDate(1996, 4, 20), "m"));
        repository.add(new Person(4, "Marta", new LocalDate(1999, 6,5), "w"));
        repository.add(new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w"));
    }

    @Test
    void removeFirstPerson() {
        Person[] expected = new Person[]{
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w")
        };
        repository.removePerson(0);
        assertArrayEquals(expected, repository.getPersons());
    }

    @Test
    void removeLastPerson() {
        Person[] expected = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w")
        };
        repository.removePerson(4);
        assertArrayEquals(expected, repository.getPersons());
    }

    @Test
    void removePersonInCenter() {
        Person[] expected = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w")
        };
        repository.removePerson(2);
        assertArrayEquals(expected, repository.getPersons());
    }

    @Test
    void getAgeOfPerson() {
        Integer expected = 20;
        Integer actual = repository.getAgeOfPerson(4);
        assertEquals(expected, actual);
    }

    @Test
    void searchByDateOfBirth() {
        Person[] expected = new Person[]{
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w")
        };
        Person[] actual = repository.searchByDateOfBirth(new LocalDate(1999, 6, 5)).getPersons();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByGenderMan() {
        Person[] expected = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m")
        };
        Person[] actual = repository.searchByGender("m").getPersons();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByGenderWoman() {
        Person[] expected = new Person[]{
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w")
        };
        Person[] actual = repository.searchByGender("w").getPersons();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {
        Person[] expected = new Person[]{
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
        };
        Person[] actual = repository.searchByName("Jane").getPersons();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameNoInput() {
        Person[] expected = new Person[]{
                new Person(1,"Alex", new LocalDate(1997, 3, 1),"m"),
                new Person(2, "Jane", new LocalDate(1995,11,2), "w"),
                new Person(3,"Max", new LocalDate(1996, 4, 20), "m"),
                new Person(4, "Marta", new LocalDate(1999, 6,5), "w"),
                new Person(5, "Lucy", new LocalDate(1998,8,12 ), "w")
        };
        Person[] actual = repository.searchByName("").getPersons();
        assertArrayEquals(expected, actual);
    }
}