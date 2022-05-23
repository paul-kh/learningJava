import java.util.*;
class Student implements Comparable<Student> {    
int marks;  
Student(int marks){ 
  this.marks = marks; 
}    
public String toString() {
  return (" " + this.marks); 
  }   
public int compareTo(Student stu){
  // Sort decending order
  if(this.marks==stu.marks)
      return 0;
  else if(marks<stu.marks)  
      return 1;  
  else  
      return -1;        
}
}
public class TreeSetComparable{
public static void main(String[] args){       
  TreeSet<Student> setmarks = new TreeSet<>();
  Student s1=new Student(500);
  Student s2=new Student(400);
  Student s3=new Student(100);
  Student s4=new Student(200);
  Student s5=new Student(300);
  setmarks.add(s1);
  setmarks.add(s2);
  setmarks.add(s3);
  setmarks.add(s4);
  setmarks.add(s5);     
  System.out.println("The Students marks in descending order : " + setmarks);       
}
}
