class StudentClass{
 int extMark, total; 
String rollNo;
 final int internalMark=18;    
  class InnerStudent{  
         public void StudentMarks(String rNo,int externalMark){
             rollNo=rNo;
             extMark=externalMark;
             total=externalMark+internalMark;
             System.out.println("Student Rollnumber:" + rNo);
             System.out.println("Total marks: " + total);
             }  
      }  
}
public class InnerClass {
 public static void main(String args[]){  
  StudentClass outerClass=new StudentClass();
  StudentClass.InnerStudent InnerClass=outerClass.new InnerStudent();
  InnerClass.StudentMarks("SCS1024",68);
}  
}
