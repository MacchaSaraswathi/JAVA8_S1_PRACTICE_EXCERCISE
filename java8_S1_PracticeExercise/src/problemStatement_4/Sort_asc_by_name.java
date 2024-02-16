package problemStatement_4;


import java.util.*;

class Persons {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Persons(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }

    public static Comparator<Persons> NameComparator = new Comparator<Persons>() {
        public int compare(Persons p1, Persons p2) {
            return p1.name.compareTo(p2.name);
        }
    };
}

public class Sort_asc_by_name {
    public static void main(String[] args) {
        List<Persons> persons = new ArrayList<>();
        persons.add(new Persons(1, "Jerry", 12, 999.0));
        persons.add(new Persons(5, "John", 32, 1999.0));
        persons.add(new Persons(4, "Jones", 22, 6999.0));
        persons.add(new Persons(3, "Popeye", 21, 5999.0));
        persons.add(new Persons(2, "Smith", 22, 2999.0));
        persons.add(new Persons(6, "Tom", 42, 3999.0));

        Collections.sort(persons, Persons.NameComparator);

        System.out.println("Sorted By Ascending Name-");
        System.out.println("-----------------");
        for (Persons person : persons) {
            System.out.println(person);
        }
    }
}


