package problemStatement_4;

import java.util.function.Consumer;

class all_names1 {
    private int id;
    private String name;
    private double salary;

    public all_names1(int id, String name, double salary) {
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

public class all_names_uppercase {
    public static void main(String[] args) {
    	all_names1[] persons = {
            new all_names1(1, "Jerry", 999.0),
            new all_names1(2, "Smith", 2999.0),
            new all_names1(3, "Popeye", 5999.0),
            new all_names1(14, "Jones", 6999.0),
            new all_names1(15, "John", 1999.0),
            new all_names1(16, "Tom", 3999.0)
        };

        Consumer<all_names1> printInfo = person -> {
           // System.out.println("Id: " + person.getId());
        
            System.out.println(person.getName().toUpperCase());
         //   person.getName().toUpperCase();
            
          //  System.out.println("Salary: " + person.getSalary());
           // System.out.println();
        };

        for (all_names1 person : persons) {
        	
            printInfo.accept(person);
        }
    }
}



