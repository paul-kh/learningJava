import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

// ArrayList that stores CUSTOM OBJECT
public class ArrayListCollection_Experiment2 {
    public static void main(String[] args) {

        ArrayList<Car> carList = new ArrayList<>();

        carList.add(new Car("Honda", "Civic", 20000.0));
        carList.add(new Car("Toyota", "Camry", 20500.0));
        carList.add(new Car("BMW", "5 Series", 40000.0));

        System.out.println("Car List: " + carList);

        // ArrayList storing String objects
        ArrayList<String> fruitList = new ArrayList<>();

        fruitList.add("Apple");
        fruitList.add("Banana");

        System.out.println("Fruit List: " + fruitList);
    }
}
