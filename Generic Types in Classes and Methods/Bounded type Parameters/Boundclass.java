class Numclass<T extends Number>
{
    T t;    
    public Numclass(T t) {
    this.t = t;
 }    
 void display(){
         System.out.println("Value is : "+t);
         System.out.println("The Type of given value is : "+t.getClass().getName());            
 }
}
public class Boundclass {
 public static void main(String[] args){
     Numclass<Integer> n1 = new Numclass<Integer>(100);
     n1.display();        
     Numclass<Double> n2 = new Numclass<Double>(101.5);
     n2.display();    
 }
}
