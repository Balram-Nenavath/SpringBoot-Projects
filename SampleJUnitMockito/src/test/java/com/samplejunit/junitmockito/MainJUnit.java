package com.samplejunit.junitmockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainJUnit {
	
	public static void main(String[] args)
	{
		//JUnitCore.runclasses
		Result result = JUnitCore.runClasses(DemoJUnit.class);
		//mockito.mock
		DemoJUnit demo = mock(DemoJUnit.class);
		for(Failure failure: result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println("Result :: "+result.wasSuccessful());
		
		demo.testAssertions();
	}
	
	
	
//	@Test
//	public void test()
//	{
//		//mockito.mock
//				DemoJUnit demo = mock(DemoJUnit.class);
//				when(demo.testAssertions()).thenReturn(3);
//				assertEquals(2, demo.toString());
//	}

}
