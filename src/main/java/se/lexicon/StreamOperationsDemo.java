package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsDemo {

    public static void main(String[] args) {

        ex9();
    }
    /** Terminal op (TO)*/

    // count() - amount of elements in stream - return long number
    public static void ex1(){

    Stream<String>  programmingLanguages  = Stream.of("Java", "C#", "Python", "C++");
    long result = programmingLanguages.count();

    System.out.println(result); //4
    }

    //Max() & Min()
    public static void ex2(){


        List<Integer> numbers = Arrays.asList(2, 100, 1, 12, 100000, 20000);


        Optional<Integer> maxOptional1 = numbers.stream() //Method Reference
                                           .max((o1, o2) -> {
                                               //max ()  - compare 2 objects - return Optional
                                               // looking for max - "sort" the stream
                                                if (o1>o2)return 1;
                                                else if (o1<o2) return -1;
                                                else return 0;
                                                });

        Optional<Integer> maxOptional2 = numbers.stream()
                                            .max((o1, o2) -> o1.compareTo(o2)); //lambda

        Optional<Integer> maxOptional3 = numbers.stream().max((Integer::compareTo)); //Method Reference

        if (maxOptional3.isPresent())  //is present() = max found
            System.out.println(maxOptional3.get());
            else
                System.out.println("-");



          }

    //findFirst()
    public static void ex3(){
        List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik");
        Optional<String> optional = names.stream().findFirst();
        // we can combine and add filter()
        //Optional<String> optional = names.stream().filter(name -> name.startsWith("K")).findFirst();

        if (optional.isPresent()) System.out.println(optional.get());

    }

    public static void ex4(){
        List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik");

        Predicate<String> checkLength = name ->name.length()>5; //condition

        System.out.println(names.stream().allMatch(checkLength)); //false
        System.out.println(names.stream().anyMatch(checkLength)); //true
        System.out.println(names.stream().noneMatch(checkLength)); //false

    }

    //collect()
    public static void ex5(){
        List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Marcus","Mehrdad");

        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("M"))
                .filter(name->name.endsWith("d"))
                .collect(Collectors.toList());

        filteredNames.forEach(n -> System.out.println(n));  //lambda
        filteredNames.forEach(System.out ::println);        // MR

    }

   /**Intermediate Operations IO  */
   //filter
   public static void ex6(){
       List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Marcus","Mehrdad");

       names.stream()
               .filter(name->name.startsWith("M"))
               .filter(name->name.endsWith("d"))
               .forEach(System.out::println);
   }
   public static void ex7(){
      Stream<Integer> integerStream = Stream.iterate(1,integer -> integer+1); //generate infinite Stream
        integerStream.limit(20).forEach(System.out::println); //limit the infinite stream
   }
   public static void ex8(){
       List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Marcus","Mehrdad");
        names.stream().skip(3).limit(2).forEach(System.out::println); //Kent, Fredrik

        // skip - first x elements
       //limit - how many elements from x+1

   }
   public static void ex9(){

       List<Person> personList = new ArrayList<>(); // create a null list of Persons
       personList.add(new Person(1, "Mehrdad", "Javan", LocalDate.parse("1989-02-27"),false));
       personList.add(new Person(2, "Marcus", "Gudmundsen", LocalDate.parse("1985-04-14"),false));
       personList.add(new Person(3, "Simon", "Elbrink", LocalDate.parse("1994-10-28"),false));

       Comparator<Person> personComparatorLambda= (o1, o2) ->o1.getFirstName().compareTo(o2.getFirstName());
       Comparator<Person> personComparatorMR= Comparator.comparing(Person::getFirstName);
       personList.stream()
               .sorted(personComparatorMR)
               .forEach(System.out::println);
   }
}
