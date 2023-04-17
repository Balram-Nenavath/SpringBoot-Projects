import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SkipandLimitExample {

	public static void main(String[] args) throws IOException
	{
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		for(int i=1;i<=numbers.size()-3;i++)
		{
			System.out.println("trad : "+numbers.get(i));
		}
		//skip (1) it will remove 1 from the list and then limit will start its operations from 1st position which is 2
		//start count 1 from skipped index to reach limit
		// and reaches 8 which will be in 7th position
		numbers.stream().skip(1).limit(7).forEach(System.out::println);
		
		
		System.out.println("***************************");
		
		List<String> file = Files.readAllLines(Paths.get("C:\\PROJECTS\\Java8FeaturesDemo\\resources\\Data.txt"));
		file.stream()
		.skip(1)
		.limit(file.size()-2)
		.forEach(System.out::println);
	}
	
	
}
