import java.util.*;
class Wildcard{
 public static double sum(List<? extends Number> numlist){
     double sum=0.0;
     for (Number i: numlist)
     {
         sum+=i.doubleValue();
     }  
     return sum;
 }
}
public class Upperboundwild {
 public static void main(String[] args){                
     List<Integer> intlist= Arrays.asList(25,25,45,55);          
     System.out.println("Sum of Integer value:"+Wildcard.sum(intlist));        
     List<Double> doublist=Arrays.asList(2.5, 4.6,5.2,4.6);   
     System.out.println("Sum of Double value:"+Wildcard.sum(doublist));
 }  
}
