import java.util.Arrays;

public class Reassignment {
    public static void main(String[] args) {

        String[] arrayOfFruits = new String[] {"apple", "banana", "kiwi", "strawberry"};

        System.out.println("- Inside main() BEFORE reassignArray() invocation: " + Arrays.toString(arrayOfFruits));
        reassignArray(arrayOfFruits);
        System.out.println("- Inside main() AFTER reassignArray() invocation: " + Arrays.toString(arrayOfFruits));
    }

    // Reassigning an array object will not affect the original one ==> PASS-BY-VALUE (creating a copy of the original object)
    public static void reassignArray(String[] arrayOfFruits) {
        System.out.println("- The original array -- inside reassignArray(): " + Arrays.toString(arrayOfFruits));

        arrayOfFruits = new String[] {"watermelon", "papaya"};

        System.out.println("- The array after reassignment (inside function): " + Arrays.toString(arrayOfFruits));

        System.out.println("- The array after updating (inside function): " + Arrays.toString(arrayOfFruits));
    }
}

