import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Stream_MapReduce {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 9, 6, 1, 5, 4);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        //trad way
        int sum = 0;
        for (int no : numbers) {
            sum = sum + no;
        }
        System.out.println(sum);

        //using map
        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        //using map and reduce
        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        //using method reference ::
        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodReference.get());

        //multiplication using reduce
        Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(mulResult);

        //max value
        Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxvalue);

        //maxvalue using method reference ::
        Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxvalueWithMethodReference);


        String longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(longestString);

        //get employee whose grade A
        //get salary
        double avgSalary = Database.getAll().stream()
                .filter(Emp -> Emp.getName().equalsIgnoreCase("Ram"))
                .map(Emp -> Emp.getsalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println(avgSalary);

        double sumSalary = Database.getAll().stream()
                .filter(Emp -> Emp.getName().equalsIgnoreCase("Ram"))
                .map(Emp -> Emp.getsalary())
                .mapToDouble(i -> i)
                .sum();
        System.out.println(sumSalary);
    }


}
