package org.example;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Person Class - Activity 5
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // overide the default toString
    @Override
    public String toString(){
        return name + " - " + age;
    }
}

public class JavaStreams {
    public static void main(String[] args) {
    // Activity 1: Filter Odd Numbers
        System.out.println("--- Activity 1 Start ---");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        //List<Integer> n = List.of(1,2,3,4,5,6,7,8,9,10);
        //System.out.println("Original: " + numbers); // Debug
        Predicate<Integer> isOdd = number -> number % 2 != 0;

        List<Integer> oddNumbers = numbers.stream()  // Convert the list to a stream
                .filter(isOdd) // Apply isOdd predicate to filter
                .toList(); //.collect(Collectors.toList());

        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("--- Activity 1 End ---");
        System.out.println();

    // Activity 2: Filter Strings Starting with 'A'
        System.out.println("--- Activity 2 Start ---");
        List<String> names = List.of("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s -> s.startsWith("A");

        List<String> listOfNames = names.stream()
                        .filter(startsWithA).toList(); //using toList instead of .collect(Collectors.toList());

        System.out.println(listOfNames);
        System.out.println("--- Activity 2 End ---");
        System.out.println();

    // Activity 3: Square all numbers
        System.out.println("--- Activity 3 Start ---");
        List<Integer> n = List.of(1,2,3,4,5);

        List<Integer> listOfSquares = n.stream()
                .map(num -> num*num).toList();

        System.out.println(listOfSquares);

        System.out.println("--- Activity 3 End ---");
        System.out.println();

    // Activity 4: Combine Predicates
        System.out.println("--- Activity 4 Start ---");
        List<Integer> numAct4 = List.of(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isGreaterThan5 = number -> number > 5;
        Predicate<Integer> combined = isEven.and(isGreaterThan5);

        List<Integer> checkingList = numAct4.stream()
                        .filter(combined).toList();
        System.out.println(checkingList);
        System.out.println("--- Activity 4 End ---");
        System.out.println();

    // Activity 5: Sort Objects Using Comparator
        System.out.println("--- Activity 5 Start ---");
        List <Person> persons = Arrays.asList(
                new Person("Alice", 24),
                new Person("Bob", 20),
                new Person("Charlie", 19),
                new Person("Delta", 30),
                new Person("Ethan", 21)
        );
        // Ascending Age
        List<Person> sortedByAgeAsc = persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted by age (ascending): ");
        sortedByAgeAsc.forEach(System.out::println);
        System.out.println();

        // By name
        List<Person> sortedByName = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        System.out.println("Sorted by name: ");
        sortedByName.forEach(System.out::println);
        System.out.println();

        // Descending Age
        List<Person> sortedByAgeDesc = persons.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        System.out.println("Sorted by age (descending): ");
        sortedByAgeDesc.forEach(System.out::println);

        System.out.println("--- Activity 5 End ---");
        System.out.println();
    }
}