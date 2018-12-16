package Repository;

import Comparators.*;
import Person.Person;
import SearchRepository.*;
import SortRepository.*;
import org.joda.time.LocalDate;


public class Repository {

    private Sorter sorter;
    final private int DEFAULT_SIZE = 10;
    private int size;
    private Person[] persons = new Person[DEFAULT_SIZE];

    public Repository(){

    }

    public Repository(Sorter s) {

        this.sorter = s;
    }

    /**
     * @return array with new size
     */
    private Person[] resize() {
        Person[] newPerson = new Person[size + 1];
        System.arraycopy(persons, 0, newPerson, 0, persons.length);
        return newPerson;
    }

    /**
     * @param p Person object
     */
    public void add(Person p) {
        if (persons.length == size) {
            persons = resize();
        }
        persons[size] = p;
        this.size++;
    }

    /**
     * @param index person to remove
     */
    public void removePerson(int index) {
        size--;
        if (index == 0) {
            Person[] newPersons = new Person[persons.length - 1];
            System.arraycopy(persons, 1, newPersons, 0, newPersons.length);
            persons = newPersons;
        } else if (index == persons.length - 1) {
            Person[] newPersons = new Person[persons.length - 1];
            if (newPersons.length >= 0)
                System.arraycopy(persons, 0, newPersons, 0, newPersons.length);
            persons = newPersons;
        } else {
            Person[] newPersons = new Person[persons.length - 1];
            for (int i = 0; i < persons.length; i++) {
                if (i < index)
                    newPersons[i] = persons[i];
                else if (i == index) {
                    continue;
                } else
                    newPersons[i - 1] = persons[i];

            }
            persons = newPersons;
        }
    }

    /**
     * @return array persons
     */
    public Person[] getPersons() {
        Person[] result = new Person[size];
        System.arraycopy(persons, 0, result, 0, result.length);
        return result;
    }

    /**
     * @param index person to take
     * @return age
     */
    public int getAgeOfPerson(int index) {

        return persons[index].findAge();
    }

    public void sortBy(PersonComparator comparator) {

        sorter.sort(persons, comparator);
    }

    private Repository search(Searcher p, Object value) {

        Repository result = new Repository();
        for (int i = 0; i < size; i++) {
            if (p.search(persons[i], value))
                result.add(persons[i]);
        }
        return result;
    }

    public Repository searchByDateOfBirth(LocalDate dateOfBirth) {

        return search(new SearchByDateOfBirth(), dateOfBirth);
    }

    public Repository searchByGender(String gender) {

        return search(new SearchByGender(), gender);
    }

    public Repository searchByName(String name) {

        return search(new SearchByName(), name);
    }
}
