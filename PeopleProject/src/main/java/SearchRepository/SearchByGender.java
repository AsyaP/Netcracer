package SearchRepository;

import Person.Person;

public class SearchByGender implements Searcher{

    @Override
    public boolean search(Person p, Object value){

        return p.getGender().equals(value);
    }

}
