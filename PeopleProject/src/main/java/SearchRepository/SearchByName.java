package SearchRepository;

import Person.Person;

public class SearchByName implements Searcher{

    @Override
    public boolean search(Person p, Object value){

        return p.getName().contains(value.toString());
    }
}
