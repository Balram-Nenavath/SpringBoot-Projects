

import java.util.function.BiPredicate;

public class BiPredicateFI {


    public static void main(String[] args) {


        BiPredicate<String,String> biPredicate=new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        System.out.println(biPredicate.test("madam","madam"));


        BiPredicate<String,String> equalsPredicate= ( s1,  s2) ->s1.equals(s2);
        BiPredicate<String,String> lengthPredicate=(s1,s2)->s1.length()==s2.length();

        //AND if first is false then other one is not evaluated
        boolean output=lengthPredicate.and(equalsPredicate).test("madam1","madam");
        System.out.println("output : "+output);
      //OR if first is true then other one is not evaluated
        boolean orOutput=lengthPredicate.or(equalsPredicate).test("abc","def");
        System.out.println("orOutput : "+orOutput);

        System.out.println(equalsPredicate.test("madam1","madam"));
        System.out.println(lengthPredicate.test("madam","madam"));

    }
}
