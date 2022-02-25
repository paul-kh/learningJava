public class StringSubclass {
    public static void main(String[] args) {

        String string = new String("A String"); // String is a subclass derived from the baseclass "Object" in java.lang.String

        // NOTE: The subclass 'String' overrides the .toString() method of its parent class "Object"
        System.out.println("String representation of the object 'string': " + string.toString());
        System.out.println("Class of the object 'string': " + string.getClass());
        System.out.println("Hash code of the object 'string': " + string.hashCode());

        String anotherString = new String("Another String");

        System.out.println("\nString representation of anotherString: " + anotherString.toString());
        System.out.println("Are they equal?: " + string.equals(anotherString));

        String stringCopy = string;

        System.out.println("\nString representation of stringCopy: " + stringCopy.toString());
        System.out.println("Are they equal?: " + string.equals(stringCopy));

    }
}
