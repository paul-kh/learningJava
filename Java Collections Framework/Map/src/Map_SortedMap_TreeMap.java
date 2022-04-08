import java.util.Comparator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/*
    Sort descending books by integer ID using the Comparator interface.
    Book is a custom object.
 */

public class Map_SortedMap_TreeMap {

    public static void main(String[] args) {

        Comparator<Integer> descendingComparator = new Comparator<>() {

            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2) * -1;
            }

        };

        SortedMap<Integer, String> treeMap = new TreeMap<>(descendingComparator);

        treeMap.put(1784, "Back to the Future");
        treeMap.put(1503, "Titanic");
        treeMap.put(1202, "Jaws");
        treeMap.put(1501, "Forrest Gump");
        treeMap.put(1277, "The Godfather");

        System.out.println("Entries in the reverse order: ");

        for (Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry);
        }

    }
}
