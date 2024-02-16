package problemStatement_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AllPerson {
    private int id;
    private String name;
    private int age;
    private double salary;

    public AllPerson(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AllPerson [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

public class Sort_desc_by_name {
    public static void main(String[] args) {
        List<AllPerson> persons = new ArrayList<>();
        persons.add(new AllPerson(6, "Tom", 42, 3999.0));
        persons.add(new AllPerson(2, "Smith", 22, 2999.0));
        persons.add(new AllPerson(3, "Popeye", 21, 5999.0));
        persons.add(new AllPerson(4, "Jones", 22, 6999.0));
        persons.add(new AllPerson(5, "John", 32, 1999.0));
        persons.add(new AllPerson(1, "Jerry", 12, 999.0));

        // Sort persons by name in descending order
        Collections.sort(persons, Comparator.comparing(AllPerson::getName).reversed());

        // Print sorted persons
        System.out.println("Sorted by Descending order using Name");
        for (AllPerson person : persons) {
            System.out.println(person);
        }
    }
}

