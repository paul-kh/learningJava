import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class HashSet_collection {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        System.out.println("hashSet instanceof HashSet " + (hashSet instanceof HashSet));
        System.out.println("hashSet instanceof Set " + (hashSet instanceof Set));
        System.out.println("hashSet instanceof Collection " + (hashSet instanceof Collection));
        System.out.println("hashSet instanceof Iterable " + (hashSet instanceof Iterable));
        System.out.println();

        HashSet<String> carSet = new HashSet<>();

        carSet.add("Volvo");
        carSet.add("BMW");
        carSet.add("Ford");
        carSet.add("Mazda");

        System.out.println("Cars set:" + carSet);

        System.out.println();

        // Run

        System.out.println("************ Duplicates are not allowed in sets");

        carSet.add("BMW");
        carSet.add("Ford");

        System.out.println("Cars set:" + carSet);

        System.out.println();

        // Run

        System.out.println("************ Null values are allowed");

        carSet.add(null);
        carSet.add(null);
        carSet.add(null);

        System.out.println("Cars set:" + carSet);

        System.out.println();
    }
}
