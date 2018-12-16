package Tests;

import Person.Person;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p;

    @Test
    void findAge() {
        p = new Person(0, "Mike", new LocalDate(1998, 9, 11),"w");
        Integer expected = 20;
        Integer actual = p.findAge();
        assertEquals(expected, actual);
    }
}
