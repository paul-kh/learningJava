import java.math.BigInteger;

public class EmployeeBean {

    private BigInteger id;
    private String name;
    private String title;
    private double  salary;
    private int age;

    //this default no-argument constructor is a must for Bean object
    public EmployeeBean () {
    }

    public EmployeeBean(BigInteger id, String name, String title, double salary, int age) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.salary = salary;
        this.age = age;
    }

    public BigInteger getId(){
        return id;
    }
    public void setId(BigInteger id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
