import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.json.JSONPropertyName; // Dictate name of field to be created in JSON while serializing
import org.json.JSONPropertyIgnore; // Ignore the field creation in JSON while serializing

public class EmployeeBean {

    private BigInteger id;
    private String name;
    private String title;
    private double  salary;
    private int age;
    private boolean active;

    //The org.json can also convert the result returned from the is__ method to JSON as well
    public Boolean isActive() { return active; }

    public void setActive(Boolean active) {this.active = active; }

    // Nested objects "list of committees" since 1 person can belong to many committees
    private List<CommitteeBean> committeeList;

    //Setter and getter of committeeList
    @JSONPropertyName("committees") // Dictate the field name in JSON when serializing
    public List<CommitteeBean> getCommitteeList() { return committeeList; }

    public void setCommitteeList(CommitteeBean... committeeList) { this.committeeList = Arrays.asList(committeeList); }

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

    @JSONPropertyName("employee_id") // Dictate the field name in JSON when serializing
    public BigInteger getId(){ return id; }

    public void setId(BigInteger id) { this.id = id;  }

    @JSONPropertyName("full_name") // Dictate the field name in JSON when serializing
    public String getName(){ return name;   }

    public void setName(String name){   this.name = name; }

    public String getTitle(){    return title;   }

    public void setTitle(String title) { this.title = title;  }

    @JSONPropertyIgnore
    public double getSalary(){ return salary;   }

    public void setSalary(double salary){       this.salary = salary;   }

    @JSONPropertyIgnore
    public int getAge(){   return age;    }

    public void setAge(int age){ this.age = age;    }

}
