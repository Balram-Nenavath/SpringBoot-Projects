
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerFI implements BiConsumer<String,Integer> {
    @Override
    public void accept(String m1, Integer m2) {
        System.out.println("input 1 "+m1 +": input 2 "+m2);
    }
//traditional approach
    public static void main(String[] args) {
        BiConsumer<String,Integer> biConsumer=new BiConsumerFI();
        biConsumer.accept("Balram",5300);
//-----------------
     
        BiConsumer<String,Integer> biConsumer1=new BiConsumer<String, Integer>() {
            @Override
            public void accept(String m1, Integer m2) {
                System.out.println(m1+":"+m2);
            }
        };
        //anonymous approach
        biConsumer1.accept("Welcome",3324);
//using lambda approach
        BiConsumer<String,Integer> biConsumer2= ( m1,  m2) -> System.out.println("key :"+m1+" value :"+m2);
        biConsumer2.accept("Sai",7286);

        Map<String, Integer> map=new HashMap<>();
        map.put("basant",5000);
        map.put("santosh",15000);
        map.put("jashwanth",12000);

        map.forEach((k,v)-> System.out.println(k+","+v));

        map.entrySet().stream().filter(v->v.getValue()>6000).forEach(obj-> System.out.println(obj));
    }
}
