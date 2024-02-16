package problemStatement_4;

import java.util.function.Consumer;

class all_Persons {
    private int id;
    private String name;
    private double salary;

    public all_Persons(int id, String name, double salary) {
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

public class Appraisal_to_name_salary {
    public static void main(String[] args) {
    	all_Persons[] persons = {
            new all_Persons(1, "Jerry", 999.0),
            new all_Persons(2, "Smith", 2999.0),
            new all_Persons(3, "Popeye", 5999.0),
            new all_Persons(14, "Jones", 6999.0),
            new all_Persons(15, "John", 1999.0),
            new all_Persons(16, "Tom", 3999.0)
        };

        Consumer<all_Persons> printInfo = person -> {
           // System.out.println("Id: " + person.getId());
            System.out.println("Name is: " + person.getName() +" "+ "and salary is: " + person.getSalary());
           // System.out.println("Salary: " + person.getSalary());
           // System.out.println();
        };

        for (all_Persons person : persons) {
            printInfo.accept(person);
        }
    }
}


