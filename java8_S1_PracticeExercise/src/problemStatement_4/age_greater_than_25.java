package problemStatement_4;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class AllPersons {
    private int id;
    private String name;
    private int age;
    private double salary;

    public AllPersons(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "AllPersons [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

public class age_greater_than_25 {
    public static void main(String[] args) {
        List<AllPersons> persons = new ArrayList<>();
        persons.add(new AllPersons(6, "Tom", 42, 3999.0));
        persons.add(new AllPersons(2, "Smith", 22, 2999.0));
        persons.add(new AllPersons(3, "Popeye", 21, 5999.0));
        persons.add(new AllPersons(4, "Jones", 22, 6999.0));
        persons.add(new AllPersons(5, "John", 32, 1999.0));
        persons.add(new AllPersons(1, "Jerry", 12, 999.0));

        Predicate<AllPersons> ageGreaterThan25 = person -> person.getAge() > 25;

        System.out.println("Persons whose age is greater than 25:");
        persons.stream()
                .filter(ageGreaterThan25)
                .forEach(System.out::println);
    }
}


