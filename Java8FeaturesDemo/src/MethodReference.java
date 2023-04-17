
public class MethodReference {

	public void m1()
	{
		System.out.println(" m1 :: Instance method");
	}
	
	public static void m2()
	{
		System.out.println(" m2 :: Static method");
	}
	
	public static void main(String[] args)
	{
		
		
		//reference :: methodName
		
		//MethodReference::m2(); // static method reference
		
		
		MethodReference.m2();
		
		MethodReference mref = new MethodReference();
		mref.m1();
		
		
		// MethodReference::m1(); //instance method reference
		
	}
	
}
