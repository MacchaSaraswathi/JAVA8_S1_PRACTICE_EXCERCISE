package problemStatement_4;

import java.util.function.Consumer;

class all_Person {
    private int id;
    private String name;
    private double salary;

    public all_Person(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class Print_id_name_salary {
    public static void main(String[] args) {
    	all_Person[] persons = {
            new all_Person(1, "Jerry", 999.0),
            new all_Person(2, "Smith", 2999.0),
            new all_Person(3, "Popeye", 5999.0),
            new all_Person(14, "Jones", 6999.0),
            new all_Person(15, "John", 1999.0),
            new all_Person(16, "Tom", 3999.0)
        };

        Consumer<all_Person> printInfo = person -> {
            System.out.println("Id: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Salary: " + person.getSalary());
            System.out.println();
        };

        for (all_Person person : persons) {
            printInfo.accept(person);
        }
    }
}



