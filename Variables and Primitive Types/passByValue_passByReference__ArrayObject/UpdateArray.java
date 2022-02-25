import java.util.Arrays;

public class UpdateArray {
    public static void main(String[] args) {

        String[] arrayOfFruits = new String[] {"apple", "banana", "kiwi", "strawberry"};

        System.out.println("- Inside main() BEFORE updateArray() invocation: " + Arrays.toString(arrayOfFruits));

        updateArray(arrayOfFruits, 0, "Avocado");

        System.out.println("- Inside main() AFTER updateArray() invocation: " + Arrays.toString(arrayOfFruits));
    }

    // Updating content of an array object will after the original one ==> PASS-BY-REFERENCE (pointing to the original object location)
    public static void updateArray(String[] arrayOfFruits, int index, String fruitName){
        System.out.println("- The original array -- inside arrayUpdate(): " + Arrays.toString(arrayOfFruits));

        arrayOfFruits[index] = fruitName;

        System.out.println("- The array after updating inside updateArray(): " + Arrays.toString(arrayOfFruits));

    }
}
