import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {

	/*
	 * ( o1, o2) -> o2.getName().compareTo(o1.getName());
	 */
	
	//trad way used to create an interface and implement it and create a method inside and create execution flow
//	public void m1()
//	{
//		System.out.println(" lambda demo");
//	}
	
	//lambda - converting abstract method to anonymous method
//	()  {		System.out.println(" lambda demo");	}
	
	
	public List<Emp> getEmpDatainSort() {
		List<Emp> empData = new Database().getEmp();
		//Collections.sort(empData, new MyComparator());
		Collections.sort(empData, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return empData;
	}

	public static void main(String[] args) {
		System.out.println(new LambdaDemo().getEmpDatainSort());
			
	}
}


//  class MyComparator implements Comparator<Emp> {
//  
//  @Override 
//  public int compare(Emp o1, Emp o2) 
//  {
//	  return o2.getName().compareTo(o1.getName()); 
//	 }
//}