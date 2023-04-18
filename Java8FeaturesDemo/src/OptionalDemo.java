
/*public class MyClass {
public static void main(String[] args)
{
	Emp e1= new Emp();
	e1.setId(1);
	e1.setName("Ram");
	
	Emp e2= new Emp();
	e2.setId(1);
	e2.setName("Ram");
	
	System.out.println("Shallow compare : "+ (e1==e2));
	System.out.println("Deep compare : "+ (e1.equals(e2)));

}
}*/


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {



	
	public static Emp getEmpByEmailId(String email) throws Exception { 
		List<Emp>  Emps = Database.getAll(); 
		System.out.println("Stream :: "+Emps.stream().filter(Emp -> Emp.getEmail().equals(email)).findAny().orElseThrow(()->new Exception("no Emp present with this email id")));
		return Emps.stream().filter(Emp -> Emp.getEmail().equals(email)).findAny().orElseThrow(()->new Exception("no Emp present with this email id"));

	}
	 

    public static void main(String[] args) throws Exception {

     //   Emp Emp=new Emp(101, "john", "ghfghj",21654725);
        Emp Emp=new Emp(101, "john", null,  21654725);
       // Emp Emp=new Emp(101, "john", "", Arrays.asList("397937955", "21654725"));

        //empty
     

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println("Empty method : "+emptyOptional);
        
        
        //of
        //use when sure that parameter will not be null, if null will throw exception else return value

          Optional<String> emailOptionalOf = Optional.of(Emp.getEmail());
          System.out.println("Of method : "+emailOptionalOf);
        

          //ofNullable
          //use when parameter may or may not be null, if directl kept will throw error, isPresent if used to check 
        // whether value is null or not,if null- false and wont print anything

          Optional<String> emailOptional2 = Optional.ofNullable(Emp.getEmail());
         // System.out.println("of Nullable method  0 :"+emailOptional2.get());
          if(emailOptional2.isPresent()){
              System.out.println("of Nullable method :"+emailOptional2.get());
          }
          
          System.out.println(emailOptional2.orElse("default@email.com"));
          
        //  System.out.println(emailOptional2.orElseThrow(()->new IllegalArgumentException("email not present")));
          
          System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()->"default email..."));
          
          getEmpByEmailId("kely@gmail.com");
}
}
