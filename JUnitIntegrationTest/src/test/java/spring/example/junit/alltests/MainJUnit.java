package spring.example.junit.alltests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainJUnit {
	
	public static void main(String[] args)
	{
		//JUnitCore.runclasses
		Result result = JUnitCore.runClasses(DemoJUnit.class);
		//mockito.mock
		
		for(Failure failure: result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println("Result :: "+result.wasSuccessful());
		
	}
	
	
}
