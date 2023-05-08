package Lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {

        // Generate 10 random objects
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(generateRandomPerson());
        }

        // Sort by name and age using stream
        List<Person> sortedList = personList.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted by name and age: ");
        sortedList.forEach(System.out::println);

        // Filter by city and state
        List<Person> filteredList = personList.stream()
                .filter(p -> p.getAddress().getCity().equals("New York"))
                .filter(p -> p.getAddress().getState().equals("NY"))
                .collect(Collectors.toList());

        System.out.println("\nFiltered by city and state: ");
        filteredList.forEach(System.out::println);

        // Collect to list with main field(s)
        List<String> nameList = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("\nList of names: ");
        nameList.forEach(System.out::println);
    }

    private static Person generateRandomPerson() {
        Random random = new Random();
        Person person = new Person();
        person.setName("Person " + random.nextInt(100));
        person.setAge(random.nextInt(80) + 20);
        person.setMarried(random.nextBoolean());
        Address address = new Address();
        address.setCity(random.nextBoolean() ? "New York" : "Boston");
        address.setState(random.nextBoolean() ? "NY" : "MA");
        person.setAddress(address);
        return person;
    }
}