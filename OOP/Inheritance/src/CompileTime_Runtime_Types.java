public class CompileTime_Runtime_Types {
    public static void main(String[] args) {

        Book headFirstJava = new Book();
        Book effectiveJava = new Book();

        System.out.println("Is headFirstJava an instance of Book class: " + (headFirstJava instanceof Book));
        System.out.println("Is effectiveJava an instance of Book class: " + (effectiveJava instanceof Book));

        System.out.println();

        System.out.println("Is headFirstJava an instance of Object class: " + (headFirstJava instanceof Object));
        System.out.println("Is effectiveJava an instance of Object class: " + (effectiveJava instanceof Object));

        System.out.println();

        Object headFirstJavaObject = headFirstJava;
        Object effectiveJavaObject = effectiveJava;

        System.out.println("Is headFirstJavaObject an instance of Book class: " + (effectiveJava instanceof Book));
        System.out.println("Is effectiveJavaObject an instance of Book class: " + (effectiveJava instanceof Book));

        System.out.println();

        System.out.println("headFirstJava's class: " + headFirstJava.getClass());
        System.out.println("headFirstJavaObject's class: " + headFirstJavaObject.getClass());

        System.out.println();

        System.out.println("headFirstJava binding type: " + headFirstJava.getBindingType());
        headFirstJava.checkOutBook();

        System.out.println();

        /* Notes:
           - The code below will get the compile-time error since the object "headFirstJavaObject" was declared with
             the type of the baseclass "Object" even though it's holding the object "headFirstJava" of the derived class "Book".
           - Any object declared with the type of the baseclass (Object) CANNOT invoke any method of the derived class (Book)

        System.out.println("headFirstJavaObject binding type: " + headFirstJavaObject.getBindingType());

        */

    }

}
