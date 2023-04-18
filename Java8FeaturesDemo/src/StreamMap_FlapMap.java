

import java.util.List;
import java.util.stream.Collectors;

public class StreamMap_FlapMap {
    public static void main(String[] args) {

        List<Customer> customers = Database.getCustomer();

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(emails);

//customer -> customer.getPhoneNumbers()  ->> one to one mapping,
        
        //map //list of streams
        List<List<String>> phoneNumbers = customers.stream()
        		.map(customer -> customer.getPhoneNumbers())
        		.collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        //flatmap //list of strings instead of streams
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}
