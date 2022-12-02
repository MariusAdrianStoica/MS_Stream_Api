package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {

    List<Person> personList = new ArrayList<>(); // create a null list of Persons
    personList.add(new Person(1, "Mehrdad", "Javan", LocalDate.parse("1989-02-27"),false));
    personList.add(new Person(2, "Marcus", "Gudmundsen", LocalDate.parse("1985-04-14"),false));
    personList.add(new Person(3, "Simon", "Elbrink", LocalDate.parse("1994-10-28"),false));

    Predicate<Person> leapYear = person -> person.getBirthdate().isLeapYear();
    Consumer<Person> printPersonInfo = person -> System.out.println(person.toString()); //P interface take param and return nothing

    personList.stream() //source
            .filter(leapYear) //intermediate op - Ctrl+P to see what you have to fill in - filter after Predicate
            .forEach(printPersonInfo); // terminal op - Consumer
        // because there is no person with birthdate in leap year -> nothing to print
        // if we change 1 birthday to year 2020 - it will print that person

    //Predicate<Person> firstNameStartsWithM = person -> person.getFirstName().startsWith("M");
        personList.stream()                                                 //source
                .filter(person -> person.getFirstName().startsWith("M"))    //intermediate op - we can write Predicate inside the filter
                .forEach(person -> System.out.println(person.getFirstName()+" "+person.getLastName()));
                    // terminal op - we can write Consumer inside the forEach



    }
}
