public class Main {

    public static void main(String[] args) {

        Car c1 = new Car();
        Car c2 = new Car("Lexus RX450h");
        Car c3 = new Car("Toyota Sienna 2021 Hybrid", 35.0f);
        Car c4 = new Car("Tesla Cyber Truck", 80.02f, 100000.02);

        c1.showCarInfo();
        c2.showCarInfo();
        c3.showCarInfo();
        c4.showCarInfo();
    }
}
