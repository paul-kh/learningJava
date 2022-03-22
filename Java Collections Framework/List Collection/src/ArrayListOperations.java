import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        List<String> cityList = new ArrayList<>();

        System.out.println("**************Adding elements");

        cityList.add("Bengaluru");
        cityList.add("New York");
        cityList.add("Mumbai");

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        System.out.println();

        // Run

        System.out.println("**************Adding elements at specified index");

        cityList.add(0, "Seattle"); // this will append list before current city of index 0 "Bengaluru"

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        cityList.add(2, "Palo Alto"); // this will append list before current city of index 2

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        System.out.println();

        // Run

        System.out.println("**************Accessing elements at the specified index");

        System.out.println("Element at index 0: " + cityList.get(0));
        System.out.println("Element at index 2: " + cityList.get(2));
        System.out.println("Element at index 4: " + cityList.get(4));

        // Run

//        System.out.println("Element at index 7: " + cityList.get(7));

        // Run - this will be an error IndexOutOfBoundsException
        // -- Comment out the line in error and continue

        System.out.println("**************Removing elements from specified index");

        System.out.println("cityList original contents: " + cityList);

        cityList.remove(0);

        System.out.println("cityList contents after removing city of index 0: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        // Run

        cityList.remove(3);

        System.out.println("cityList contents after removing city of index 3: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        System.out.println();

        // Run

        System.out.println("**************Lists can contain duplicates");
        System.out.println("cityList original contents: " + cityList);

        cityList.add("Palo Alto");
        cityList.add("Bengaluru");
        cityList.add("Mumbai");
        cityList.add("Seattle");

        System.out.println("cityList contents: " + cityList);

        System.out.println();

        // Run

        System.out.println("**************Removing elements");
        System.out.println("cityList original contents: " + cityList);

        cityList.remove(2);
        System.out.println("cityList contents: " + cityList);

        System.out.println();

        // Run

        System.out.println("**************Find the index position of an element");
        System.out.println("cityList original contents: " + cityList);

        // NOTE: That this finds the first position of the element from the beginning of the list
        System.out.println("Mumbai is at index: " + cityList.indexOf("Mumbai"));
        System.out.println("Palo Alto is at index: " + cityList.indexOf("Palo Alto"));
        System.out.println("Paris is at index: " + cityList.indexOf("Paris"));

        System.out.println();

        // Run

        System.out.println("**************Find the last index position of an element");
        System.out.println("cityList original contents: " + cityList);

        // NOTE: That this finds the last position of the element from the beginning of the list
        System.out.println("Mumbai is at index: " + cityList.lastIndexOf("Mumbai"));
        System.out.println("Bengaluru is at index: " + cityList.lastIndexOf("Bengaluru"));
        System.out.println("Palo Alto is at index: " + cityList.lastIndexOf("Palo Alto"));

        System.out.println();

        // Run

        System.out.println("**************Update an element at a specified index");
        System.out.println("cityList original contents: " + cityList);

        cityList.set(0, "Tokyo");
        cityList.set(2, "Moscow");

        System.out.println("cityList contents: " + cityList);

        System.out.println();

        // Run

        System.out.println("**************Access a sublist from the original list");
        System.out.println("cityList original contents: " + cityList);

        List<String> subList = cityList.subList(1, 4);

        System.out.println("subList contents: " + subList);

    }
}
