class Localinnerclass {
 int b=20;
 public void outerMethod(){
 int a=10;        
     class Innerclass{
         public void innerMethod(){
             System.out.println("You are inside Inner Local class");
             System.out.println("Sum of a + b is = " +(a+b));                
         }
     }
     Innerclass ob = new Innerclass();  
     ob.innerMethod();       
 }
 public static void main(String args[]){
     Localinnerclass ob1= new Localinnerclass();
     ob1.outerMethod();
 }
}
