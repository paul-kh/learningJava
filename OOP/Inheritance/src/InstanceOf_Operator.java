import java.util.Date;

public class InstanceOf_Operator {

    public static void main(String[] args) {

        String string = new String("A string");
        Date date = new Date("2/24/2022");
        Object object = new Object();

        System.out.println("Is string an instance of String class: " + (string instanceof String));
        System.out.println("Is date an instance of Date class: " + (date instanceof Date));
        System.out.println("Is object an instance of Object class: " + (object instanceof Object));

        /* NOTE: The below codes will get compile time error
        System.out.println("Is string an instance of Date class: " + (string instanceof Date));
        System.out.println("Is date an instance of String class: " + (date instanceof String));
        */

        // Note: Below codes are reasonable comparison - Result: false
        System.out.println("\nIs object an instance of String class: " + (object instanceof String));
        System.out.println("Is object an instance of Date class: " + (object instanceof Date));

    }
}
