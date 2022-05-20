interface Studentmark{
 public void Showmarks();    
}
interface Studentdet{
 public void Showdetails();    
}
class Schoolmul implements Studentdet,Studentmark{
 String stuname="Rita";
 int mark1=90;
 int mark2=85;    
 public void Showdetails(){
     System.out.println("Student Name:"+stuname);
 }
 public void Showmarks(){
     System.out.println("Mark1:"+mark1);
     System.out.println("Mark2:"+mark2);
 }
}   
class Schoolbound<T extends Schoolmul & Studentdet & Studentmark >{       
 T refobj;       
 public Schoolbound(T obj){
     this.refobj = obj;
 }       
 public void display(){
     this.refobj.Showdetails();
     this.refobj.Showmarks();
 }
}   
public class Mulbound {
 public static void main(String a[]){      
     Schoolbound<Schoolmul> mulbou = new Schoolbound<Schoolmul>(new Schoolmul());
     mulbou.display();        
 }
}
