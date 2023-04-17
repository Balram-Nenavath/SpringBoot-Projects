package spring.example.junit.alltests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DemoJUnit {


		@Spy
		ArrayList<Integer> spyArrList;
		@Mock
		private ArrayList<String> mockArrayList;

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
	
	@Test
	void whenSpyingOnArrList() {
	 
	    spyArrList.add(1);
	    spyArrList.add(2);
	    spyArrList.add(3);
	    verify(spyArrList).add(1);
	    verify(spyArrList).add(2);
	    verify(spyArrList).add(3);
	    assertThatNoException().isThrownBy(() -> doReturn(3).when(spyArrList).size());
	  // assertThat(spyArrList).hasSize(3);
	    assertEquals(spyArrList.size(),3);
	    

	}
	
	@Test
	public void spyTest()
	{
	

		//Adding Elements
		spyArrList.add(Integer.valueOf(5));
		spyArrList.add(Integer.valueOf(10));
		spyArrList.add(Integer.valueOf(15));
		
        //Verifying interactions
		Mockito.verify(spyArrList).add(5);
		Mockito.verify(spyArrList).add(10);
		Mockito.verify(spyArrList).add(15);
		
		
        //Verifying that elements were actually added to the list
		assertEquals(spyArrList.size(),3);
		
		Mockito.verify(spyArrList).add(5);
		assertEquals(true, spyArrList.contains(5));//Default normal behavior
//		
		Mockito.doReturn(false).when(spyArrList).contains(15);
		assertEquals(false, spyArrList.contains(15));//Stubbed Behavior
	}
	
	@Test
	public void testMyTest() {
	    when(mockArrayList.get(0)).thenReturn("Hello world");

	    String result = mockArrayList.get(0);

	    assertEquals("Hello world", result);

	    //used anyInt()
	    verify(mockArrayList).get(anyInt());
	  }
	
	@Test
	void whenStubbed() {
	    List<String> list = new ArrayList<String>();
	    List<String> spyList = spy(list);

	    assertEquals(0, spyList.size());

	    doReturn(100).when(spyList).size();
	    assertThat(spyList).hasSize(100);
	}
	
	
}
