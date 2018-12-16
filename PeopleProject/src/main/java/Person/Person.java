package Person;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;

    public int getId() {

        return id;
    }

    private void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    private void setName(String name) {

        this.name = name;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }

    private void setDateOfBirth(LocalDate dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {

        return gender;
    }

    private void setGender(String gender) {

        this.gender = gender;
    }

    public Person(int id, String name, LocalDate dateOfBirth, String gender) {
            this.setId(id);
            this.setName(name);
            this.setDateOfBirth(dateOfBirth);
            this.setGender(gender);
    }

    /**
     * @return person's age
     */
    public int findAge() {

        return Years.yearsBetween(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!id.equals(person.id)) return false;
        if (!dateOfBirth.equals(person.dateOfBirth)) return false;
        if (!name.equals(person.name)) return false;
        if (!gender.equals(person.gender)) return false;

        return true;
    }
}
