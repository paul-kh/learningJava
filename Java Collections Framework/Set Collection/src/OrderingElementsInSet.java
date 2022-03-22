
import java.util.*;

    public class OrderingElementsInSet {

        public static void main(String[] args) {

            String[] carsArray = new String[] {"Volvo", "BMW", "Honda", "Audi", "Mercedes"};

            Set<String> hashSet = new HashSet<>(Arrays.asList(carsArray));
            Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(carsArray));
            Set<String> treeSet = new TreeSet<>(Arrays.asList(carsArray));

            System.out.println("Order of car names in a HashSet (random order)");

            for (String name : hashSet) {
                System.out.println(name);
            }


            System.out.println("\nOrder of car names in a LinkedHashSet (insertion order)");

            for (String name : linkedHashSet) {
                System.out.println(name);
            }

            // Run

            System.out.println("\nOrder of car names in a TreeSet (natural order)");

            for (String name : treeSet) {
                System.out.println(name);
            }

            Integer[] integersArray = new Integer[] {3300, 400, 100, 700, 900, 600};

            Set<Integer> intTreeSet = new TreeSet<>(Arrays.asList(integersArray));

            // Run

            System.out.println("\nOrder of integers in a TreeSet (natural order)");

            for (Integer integer : intTreeSet) {
                System.out.println(integer);
            }

            // Run

            //treeSet.add(null);

            // Run - cannot add null values to a tree set as null is not comparable
        }
}
