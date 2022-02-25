public class ObjectBaseclass {
    public static void  main(String[] args) {

        Object object = new Object(); //"Object" is the base class from the "java.lang.Object" package

        System.out.println("String representation: " + object.toString());
        System.out.println("Class: " + object.getClass());
        System.out.println("Hash code: " + object.hashCode());

        Object anotherObject = new Object();

        System.out.println("\nString representation of anotherObject: " + anotherObject.toString());
        System.out.println("Are they equals? object.equals(anotherObject): " + object.equals(anotherObject));

        Object objectCopy = object;

        System.out.println("\nString representation of objectCopy: " + objectCopy.toString());
        System.out.println("Is the objectCopy equal to object?: " + object.equals(objectCopy));


    }
}
