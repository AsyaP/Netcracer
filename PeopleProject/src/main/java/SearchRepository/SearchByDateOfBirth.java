package SearchRepository;

import Person.Person;

public class SearchByDateOfBirth implements Searcher {

    @Override
    public boolean search(Person p, Object value) {

        return p.getDateOfBirth().equals(value);
    }
}

