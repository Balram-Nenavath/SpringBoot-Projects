import java.util.List;
import java.util.stream.Collectors;

public class StreamDebugger {

    public static void main(String args[])
    {

        List<String> names= Database.getEmp()
                .stream()
                .filter(employee -> employee.getsalary()>40000)
                .map(Employee::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
