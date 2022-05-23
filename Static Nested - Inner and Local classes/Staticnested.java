class Stuinfor{
  static String stuname;
  static int age;
  static class Studet {  
     public void Showdet(String name, int a){
         stuname=name;
         age=a;
         System.out.println("The student name:" +name);
         System.out.println("The student age:" +age);
      } 
  } 
}
public class Staticnested {
 public static void main(String args[]){  
     Stuinfor.Studet in=new Stuinfor.Studet();
     in.Showdet("Richard",15);
 }  
}
