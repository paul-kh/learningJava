public class CarUpdate {
    public static void main(String[] args) {

        Car car = new Car("Lexus RX450hL", "SUV", 28.5f);

        System.out.println("- Inside main() BEFORE function invocation: " + car);

        update(car);

        System.out.println("- Inside main() AFTER function invocation: " + car);
    }

    private static void update(Car car) {
        System.out.println("- The original 'car' object (inside function): " + car);

        car.setPrice(45000);

        System.out.println("- The object 'car' after reassignment (inside function): " + car);
    }
}
