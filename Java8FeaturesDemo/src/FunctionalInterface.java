import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class FunctionalInterface  {
	//without java 8 lambda or trad way
//	public static void main(String[] args)
//	{
//		new Thread(new Runnable() {
//            @Override public void run()
//            {
//                System.out.println("New thread created");
//            }
//        }).start();
//	}
	//with java 8 lambda
	/*
	 * public static void main(String args[]) {
	 * 
	 * // lambda expression to create the object new Thread(() -> {
	 * System.out.println("New thread created"); }).start(); }
	 */
	
	//Functional Interface using Lambda  --> only one argument and returns a result
	//Function<T,R> and used apply method    # R apply(T t)
	public static void main(String[] args)
	{
		Function<Integer,Integer> function = (num)->num*num;
		System.out.println(function.apply(8));
	}
	
	
	
	
	//============================
//	Abstract methods are those types of methods that don't require implementation for its declaration
	
	//abstract method
//		void m1()
//		{
//			
//		}	
			
	/*
	 * default methods in interfaces is to provide additional functionality to a
	 * given type without breaking down the implementing classes
	 */
	
			//default methods
//			default void m2() {
//				System.out.println("Default method-1");
//			}
		//
//			default void m3() {
//				System.out.println("Default method-2");
//			}

			//static methods
			/*
			 * A static method is a method that belongs to a class rather than an instance
			 * of a class. This means you can call a static method without creating an
			 * object of the class. Static methods are sometimes called class methods
			 */
//			static void m4() {
//				System.out.println("static method-1");
//			}
}
