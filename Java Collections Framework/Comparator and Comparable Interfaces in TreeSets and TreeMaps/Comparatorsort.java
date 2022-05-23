import java.util.Comparator;
import java.util.TreeSet; 
class Employee{
String empname;
String empid;
public Employee(String name, String id) {
this.empname = name;
this.empid = id;
} 
@Override
public String toString() {
return "Employee{" + "name=" + empname + ", id=" + empid  + '}';
}
} 
class Empnamecomp implements Comparator<Employee>{
@Override
public int compare(Employee o1, Employee o2) {
  return o1.empname.compareTo(o2.empname);
}
}
class Empidcomp implements Comparator<Employee>{
@Override
public int compare(Employee o1, Employee o2) {
  return o1.empid.compareTo(o2.empid);
}
}
public class Comparatorsort{ 
public static void main(String...a){ 
    Employee emp1=new Employee("David","4001");
    Employee emp2=new Employee("Richard","2001");
    Employee emp3=new Employee("Franklin","1000"); 
    TreeSet<Employee> treeSet = new TreeSet<Employee>(new Empnamecomp()); 
        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        System.out.println("TreeSet based on Employee name : \n"+treeSet+"\n");
    TreeSet<Employee> treeSet1 = new TreeSet<Employee>(new Empidcomp()); 
        treeSet1.add(emp1);
        treeSet1.add(emp2);
        treeSet1.add(emp3); 
         System.out.println("TreeSet based on Employeeid :\n "+treeSet1+"\n");       
}
}
