public class Car {

    private String name;
    private float mpg;
    private double price;

    // default no-argument constructor
    public Car(){
        System.out.println("*** Invoked default no-argument constructor.");
    }

    // 1-argument constructor
    public Car(String name){
        this.name = name;
        System.out.println("*** Invoked Car(String name) ");
    }

    // 2-argument constructor
    public Car(String name, float mpg){
        this(name);
        this.mpg = mpg;
        System.out.println("*** Invoked Car(String name, float mpg) ");
    }

    // 3-argument constructor
    public Car(String name, float mpg, double price){
        this(name, mpg);
        this.price = price;
        System.out.println("*** Invoked Car(String name, float mpg, double price) ");
    }

    // Member function
    public void showCarInfo() {
        System.out.println("\nObject: " + this + " | Car name: " + name + " | MPG: " + mpg + " | Price: " + price);
    }
}
