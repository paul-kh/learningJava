public class CarReassignment {
    public static void main(String[] args) {

        Car car = new Car("Lexus RX450hL", "SUV", 28.5f);

        System.out.println("- Inside main() BEFORE function invocation: " + car);

        reassignCar(car);

        System.out.println("- Inside main() AFTER function invocation: " + car);
    }

    private static void reassignCar(Car car) {
        System.out.println("- The original 'car' object (inside function): " + car);

        car = new Car("Tesla Cyber Truck", "Truck", 80.5f);

        System.out.println("- The object 'car' after reassignment (inside function): " + car);
    }
}
