import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class ArrayListCollection_Experiment1 {
    public static void main(String[] args) {

        // Non-parameterized ArrayList collection -- storing any type of objects => error-prone
        // ArrayList arrayList = new ArrayList();

        // Parameterized ArrayList collection - storing a specific type of objects => secure & less error-prone
        ArrayList<String> strArrList = new ArrayList<String>();

        System.out.println("ArrayList class: " + strArrList.getClass());  // java.util.ArrayList

        System.out.println("ArrayList instance of List interface: " + (strArrList instanceof List));
        System.out.println("ArrayList instance of Collection interface: " + (strArrList instanceof Collection));
        System.out.println("ArrayList instance of Iterable interface: " + (strArrList instanceof Iterable<?>));

    }
}
