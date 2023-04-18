package com.samplejunit.junitmockito;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DemoJUnit {

	
	@Test
	public void testAssertions()
	{
		String str1=new String("Ram");
		String str2=new String("Ram");
		String str3=null;
		String str4="Chinna";
		String str5="Chinna";
		int val1=10;
		int val2=9;
		String[] array1= {"Meenakshi","Shailu","Arjun"};
		String[] array2= {"Meenakshi","Shailu","Arjun"};
		

		List<String> list= new ArrayList<String>();
		list.add("ram");
		list.add("Krishna");
		list.add("chinna");
		
		assertEquals(str1,str2);
		
		assertTrue(val1>val2);
		
		assertFalse(val1<val2);
		
		assertNotNull(str1);
		
		assertNull(str3);
		
		assertSame(str4,str5);
		
		assertNotSame(str4,str2);
	}
}
