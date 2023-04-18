

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Database {


    public static List<Emp> getAll() {
        return Stream.of(
                new Emp(101, "Ram", "ram@gmail.com", 21625),
                new Emp(102, "Ram", "smith@gmail.com", 24207),
                new Emp(103, "Krish", "kely@gmail.com", 34896),
                new Emp(104, "Vasu", "vasu@gmail.com",94867)
        ).collect(Collectors.toList());
    }
    
    public static List<Emp> getEmp() {
		List<Emp> empData = new ArrayList<>();

		empData.add(new Emp(101, "Ram", "Ram@gmail.com",23890));
        empData.add(new Emp(102, "Smith", "smith@gmail.com",35800));
        empData.add(new Emp(103, "Krish", "krish@gmail.com",99890));
        empData.add(new Emp(104, "Vasu", "vasu@gmail.com",80890));
		return empData;
	}
    
    
    public static List<Customer> getCustomer() {
        return Stream.of(
                new Customer(101, "ram", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "krish", "krish@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "vasu", "vasu@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }

  
}
