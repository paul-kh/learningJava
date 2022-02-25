import java.util.Date; //subclass derived from the baseclass java.lang.Object

public class DateSubclass {
    public static void main(String[] args) {

        // NOTE: The constructor is deprecated but can still be used
        Date date = new Date("2/24/2022");

        //The subclass Date still inherits all methods: .toString(), .hashCode(), .equals() ... from java.lang.Object
        System.out.println("String representation: " + date.toString());
        System.out.println("Class: " + date.getClass());
        System.out.println("Hash code: " + date.hashCode());

    }
}
