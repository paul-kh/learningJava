import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>(); //List accepts Object Type but not primitive type
        // ArrayList<int>.... will give Compile Time Error

        intList.add(10);
        intList.add(20);
        intList.add(30);

        System.out.println("Integer List: " + intList);

        intList.add(null);

        System.out.println("Integer List (after adding null): " + intList);

        ///////////////////////////////////////////////////////////////
        // String Object Operations -- City List
        ArrayList<String> cityList = new ArrayList<>();

        System.out.println("**************Adding elements");

        cityList.add("Bengaluru");
        cityList.add("New York");
        cityList.add("Mumbai");

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());
        System.out.println("cityList isEmpty(): " + cityList.isEmpty());

        System.out.println();

        // Run

        System.out.println("**************Removing elements");

        cityList.remove("Seattle");
        cityList.remove("Palo Alto");

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());
        System.out.println("cityList isEmpty(): " + cityList.isEmpty());

        System.out.println();

        // Run

        System.out.println("**************Checking for elements");

        System.out.println("cityList contains New York: " + cityList.contains("New York"));
        System.out.println("cityList contains Paris: " + cityList.contains("Paris"));
        System.out.println("cityList contains Mumbai: " + cityList.contains("Mumbai"));

        System.out.println("cityList size: " + cityList.size());

        System.out.println();

        // Run

        System.out.println("**************Adding multiple elements");

        List<String> anotherCityList = new ArrayList<>();
        anotherCityList.add("Paris");
        anotherCityList.add("London");

        System.out.println("cityList original contents: " + cityList);
        System.out.println("Adding elements: " + anotherCityList);

        cityList.addAll(anotherCityList);

        System.out.println("cityList contents: " + cityList);
        System.out.println("cityList size: " + cityList.size());

        System.out.println();

        // Run

        System.out.println("**************Checking for multiple elements");

        System.out.println("cityList contains Paris, London: " + cityList.containsAll(anotherCityList));

        anotherCityList.add("Tokyo");
        System.out.println("cityList contains Paris, London, Tokyo: " + cityList.containsAll(anotherCityList));

        // Run

        System.out.println("**************Removing multiple elements");

        System.out.println("cityList original contents: " + cityList);
        System.out.println("Removing elements: " + anotherCityList);

        cityList.removeAll(anotherCityList);

        System.out.println("cityList contents: " + cityList);

    }
}
