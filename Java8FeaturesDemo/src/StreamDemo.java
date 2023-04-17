

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

	public static List<Emp> evaluateTaxUsers(String input) {
		
			return (input.equalsIgnoreCase("tax"))
					? Database.getEmp().stream().filter(emp -> emp.getsalary() > 50000).collect(Collectors.toList())
					: Database.getEmp().stream().filter(emp -> emp.getsalary() <= 50000)
							.collect(Collectors.toList());
		

	}

	public static void main(String[] args) {
		System.out.println(evaluateTaxUsers("tax1"));
	}
}
