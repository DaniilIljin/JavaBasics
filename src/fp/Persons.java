package fp;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Persons {

    private List<Person> persons = List.of(
            new Person(1, "Alice", 22),
            new Person(2, "Bob", 20),
            new Person(3, "Carol", 21));

    @Test
    public void findsPersonById() {
        List<Person> needed = persons.stream()
                .filter(p -> p.getId().equals(2))
                .toList();
        System.out.println(needed);
    }

    @Test
    public void removePersonById() {
        List<Person> needed = persons.stream()
                .filter(p -> !p.getId().equals(2))
                .toList();
        System.out.println(needed);
    }

    @Test
    public void findsPersonNames() {
        String needed = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println(needed);
    }

    @Test
    public void reverseSortedByAge() {
        List<Person> needed = persons.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Person::getAge)))
                .toList();
        System.out.println(needed);
    }

}
