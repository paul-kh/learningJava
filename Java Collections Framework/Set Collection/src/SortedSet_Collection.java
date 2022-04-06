
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSet_Collection {

    public static void main(String[] args) {

        SortedSet<String> vowelSet = new TreeSet<>();

        vowelSet.add("I");
        vowelSet.add("O");
        vowelSet.add("A");
        vowelSet.add("E");
        vowelSet.add("U");

        System.out.println("Vowels are: " + vowelSet); // Auto sorting ascending according to lexical order

        System.out.println("First vowel: " + vowelSet.first());
        System.out.println("Last vowel: " + vowelSet.last());

        System.out.println();

        // Run

        System.out.println("Vowels which come before I: " + vowelSet.headSet("I"));
        System.out.println("Vowels which come after I (includes I): " + vowelSet.tailSet("I"));

        System.out.println();

        // Run

        System.out.println("Vowels which comes between E and U (includes E): " + vowelSet.subSet("E", "U"));

        System.out.println();

        // Run
    }
}
