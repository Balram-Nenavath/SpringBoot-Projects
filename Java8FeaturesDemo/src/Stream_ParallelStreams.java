

import java.util.List;
import java.util.stream.IntStream;

public class Stream_ParallelStreams {
/*Parallel streams are meant for utilizing multiple cores of processor
 * normally java code has only one stream of processing , where it is executed sequentially
 * but in parallel streams we can divide the code into two parallel streams that are executed on different cores
 * but the final result would be the combination of both individual core streams
 */

    public static void main(String[] args) {
        long start=0;
        long end=0;

        start=System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Plain stream took time : "+(end-start));

       System.out.println("****************");

       start=System.currentTimeMillis();
       IntStream.range(1,100).parallel().forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Parallel stream took time : "+(end-start));



        IntStream.range(1,10).forEach(x->{
            System.out.println("Thread1 : "+Thread.currentThread().getName()+" : "+x);
        });

        IntStream.range(1,10).parallel().forEach(x->{
            System.out.println("Thread2 : "+Thread.currentThread().getName()+" : "+x);
        });

        List<Emp> employees = Database.getEmp();

        //normal
        start=System.currentTimeMillis();
        double salaryWithStream = employees.stream()
                .map(Emp::getsalary).mapToDouble(i -> i).average().getAsDouble();
        end=System.currentTimeMillis();

        System.out.println("Normal stream execution time : "+(end-start)+" : Avg salary : "+salaryWithStream);

        start=System.currentTimeMillis();
        double salaryWithParallelStream = employees.parallelStream()
                .map(Emp::getsalary).mapToDouble(i -> i).average().getAsDouble();

        end=System.currentTimeMillis();

        System.out.println("Parallel stream execution time : "+(end-start)+" : Avg salary : "+salaryWithParallelStream);
    }
}
