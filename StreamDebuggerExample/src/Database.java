import java.util.ArrayList;
import java.util.List;

public class Database {



    public static List<Employee> getEmp() {
        List<Employee> empData = new ArrayList<>();

        empData.add(new Employee(101, "Ram", "Ram@gmail.com",23890));
        empData.add(new Employee(102, "smith", "smith@gmail.com",35800));
        empData.add(new Employee(103, "krish", "krish@gmail.com",99890));
        empData.add(new Employee(104, "vasu", "vasu@gmail.com",80890));
        empData.add(new Employee(101, "Ram", "Ram@gmail.com",23890));
        empData.add(new Employee(104, "vasu", "vasu@gmail.com",80890));
        empData.add(new Employee(109, "krishna", "krishna@gmail.com",45000));
        return empData;
    }

}
