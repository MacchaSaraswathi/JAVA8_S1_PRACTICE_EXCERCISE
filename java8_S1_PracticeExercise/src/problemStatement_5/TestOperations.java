package problemStatement_5;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TestOperations {
	public static void main(String[] args) {
		Set<Person> person = new HashSet<>();
		Scanner s = new Scanner(System.in);
		for(int i=1;i<=6;i++)
		{
			System.out.println("Enter the Name:");
			String name=s.next();
			System.out.println("Enter the age");
			int age=s.nextInt();
			System.out.println("Enter salary:");
			double salary=s.nextDouble();
			Person p = new Person(i,name,age,salary);
			person.add(p);
		}
		person.forEach(System.out::println);//printing all the details
		
		System.out.println("Comparing using id");
		person.stream().sorted(Comparator.comparing(Person::getId)).forEach(System.out::println);
		System.out.println("Comparing using name in ascending");
		person.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
		System.out.println("Comparing using name in descending");
		person.stream().sorted(Comparator.comparing(Person::getName).reversed()).forEach(System.out::println);
		System.out.println("Name starts with J");
		person.stream().filter(p->p.getName().startsWith("J")).forEach(System.out::println);
		System.out.println("Count"+person.stream().count());
		
		Optional<Double> maxSal=person.stream().map(Person::getSalary).max(Double::compareTo);
		maxSal.ifPresent(s1->System.out.println("Max Salary  "+s1));
		Optional<Double> minSal=person.stream().map(Person::getSalary).min(Double::compareTo);
		minSal.ifPresent(s1->System.out.println("Min Salary  "+s1));
		OptionalDouble avgSal=person.stream().mapToDouble(Person::getSalary).average();
		avgSal.ifPresent(s1->System.out.println("Avg Salary  "+s1));
		double sumSal=person.stream().mapToDouble(Person::getSalary).sum();
		System.out.println("Sum of Salaries "+sumSal);
		System.out.println("First person whose name starts with 'J'");
		Optional<Person> per=person.stream().filter(p->p.getName().startsWith("J")).findFirst();
		System.out.println(per);
		System.out.println("person age is greater than 10");
		boolean b = person.stream().allMatch(p->p.getAge()>10);
		System.out.println(b);
		System.out.println("person age is greater than 50");
		boolean b1 = person.stream().noneMatch(p->p.getAge()>50);
		System.out.println(b1);
		System.out.println("Average of all salaries using Collectors");
		double averagesal=person.stream().collect(Collectors.averagingDouble(Person::getSalary));
		System.out.println(averagesal);
		Map<Double,List<Person>> groupBy=person.stream().collect(Collectors.groupingBy(Person::getSalary));
		
		System.out.println("Grouping by Salaray"+groupBy);
		System.out.println("Joing Names");
		
		System.out.println(person.stream().filter(p->p.getAge()>10).map(p->p.getName()).collect(Collectors.joining("and")));
		System.out.println("Statistics");
		DoubleSummaryStatistics sts = person.stream().collect(Collectors.summarizingDouble(p->p.getAge()));
		System.out.println(sts);
		System.out.println("Minimun is : "+sts.getMin());
		System.out.println("Maximun is : "+sts.getMax());
		System.out.println("Count is : "+sts.getCount());
		System.out.println("Average is : "+sts.getAverage());
		System.out.println("Sum is : "+sts.getSum());
		
		System.out.println("Oldest Person");
		Optional<Person> oldPerson=person.stream().reduce((p1,p2)->p1.getAge()>p2.getAge()?p1:p2);
		oldPerson.ifPresent(p->System.out.println(p));
		
		
		long start = System.currentTimeMillis();
		System.out.println("Performing Sequentially : "+person.size());
		boolean bt=person.stream().allMatch(p->p.getAge()>20);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken with Sequential  "+(end-start)+"  milli seconds");
		

		long startP = System.currentTimeMillis();
		System.out.println("Performing Parallel : "+person.size());
		boolean bt1=person.parallelStream().allMatch(p->p.getAge()>20);
		long endP = System.currentTimeMillis();
		System.out.println("Time Taken with Parallel  "+(endP-startP)+"  milli seconds");
		
		
	}
}

