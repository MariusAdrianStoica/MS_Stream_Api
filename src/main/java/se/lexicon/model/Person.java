package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    //fields
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private boolean active;

    //Constructor
    public Person(Integer id, String firstName, String lastName, LocalDate birthdate, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.active = active;
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //equals & hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return active == person.active && Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdate, active);
    }

    //toString

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", active=" + active +
                '}';
    }
}
