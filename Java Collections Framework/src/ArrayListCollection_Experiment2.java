import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

// Looping through List collection (ArrayList)
public class ArrayListCollection_Experiment2 {
    public static void main(String[] args) {

        // Parameterized Collection
        ArrayList<Car> carList = new ArrayList<>();

        carList.add(new Car("Honda", "Civic", 20000.0));
        carList.add(new Car("Toyota", "Camry", 20500.0));
        carList.add(new Car("BMW", "5 Series", 40000.0));

        // Looping using For Each
        for (Car car : carList) {
            System.out.format("%s, %s, %.1f", car.getMake(), car.getModel(), car.getPrice());
            System.out.println();
        }

        // Non-parameterized Collection
        ArrayList carList2 = new ArrayList<>();

        carList2.add(new Car("Toyota", "Lexus RX450hL", 50000.0)); // Storing Car object
        carList2.add("Tesla"); //storing String object
        carList2.add(12); // Strong Integer object

        // Looping using For Each
        for (Object obj : carList2) {
            if (obj instanceof Car) {
                // We have to check object type of every object in the non-para collection
                // before we perform any operations with it
                // Sometimes we have cast it, especially if it's a custom object
                Car car = (Car) obj;
                System.out.format("Car objet: %s, %s, %.1f", car.getMake(), car.getModel(), car.getPrice());
                System.out.println();
            }
            if (obj instanceof String) {
                //String str = (String) obj; // We don't have to cast it to String since Java auto casts for
                // objects of some primitive types
                System.out.println("String object: "+ obj + " is the leading EV maker!");
            }
            if (obj instanceof Integer) {
                Integer intNum = (Integer) obj;
                System.out.println("Float object: " + (intNum + 1));;
            }
        }
    }
}
