

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListUsingLambdaCollections {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);
		
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
		list.stream().sorted(Comparator.naturalOrder()).forEach(s->System.out.println(s));
		
		
		List<Emp> employees = Database.getEmp();

		/*Collections.sort(employees, new Comparator<Emp>() {

			@Override
			public int compare(Emp o1, Emp o2) {
				return (int) (o1.getsalary() - o2.getsalary());// ascending
			}
		});*/
		
		
		Collections.sort(employees, ( o1,  o2) ->(int) (o1.getsalary() - o2.getsalary()));

		System.out.println(employees);
		
		
		employees.stream().sorted(( o1,  o2) ->(int) (o2.getsalary() - o1.getsalary())).forEach(System.out::println);
		
		System.out.println("------------------------");
		
		employees.stream().sorted(Comparator.comparing(emp->emp.getsalary())).forEach(System.out::println);
		System.out.println("------------------------");
		employees.stream().sorted(Comparator.comparing(Emp::getName)).forEach(System.out::println);

		/*
		 * Collections.sort(list);//ASSENDING Collections.reverse(list);
		 * System.out.println(list);
		 * 
		 * list.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println
		 * (s));//descending
		 */

	}
}
