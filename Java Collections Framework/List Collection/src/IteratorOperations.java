import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IteratorOperations {
    public static void main(String[] args) {
        List<String> cityList = new ArrayList<>();

        System.out.println("**************Adding elements");

        cityList.add("New York");
        cityList.add("Mumbai");
        cityList.add("Seattle");
        cityList.add("Tokyo");

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        System.out.println();

        // Run

        System.out.println("**************The iterable interface allows iterating over lists");

        Iterable<String> cityListIterable = cityList;
        Iterator<String> iterator = cityListIterable.iterator();

        System.out.println("Iterator hasNext(): " + iterator.hasNext());
        System.out.println("Iterator next(): " + iterator.next());

        System.out.println("Iterator hasNext(): " + iterator.hasNext());
        System.out.println("Iterator next(): " + iterator.next());

        System.out.println("Iterator hasNext(): " + iterator.hasNext());
        System.out.println("Iterator next(): " + iterator.next());

        System.out.println("Iterator hasNext(): " + iterator.hasNext());
        System.out.println("Iterator next(): " + iterator.next());

        System.out.println("Iterator hasNext(): " + iterator.hasNext());

        // Run

//        System.out.println("Iterator next(): " + iterator.next());

        // Run -- this will be an error NoSuchElementException
        // Comment out the code before moving on
    }
}
