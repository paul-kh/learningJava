public class Car {

    private String make;
    private String model;
    private Double price;

    public Car(String make, String model, Double price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Make: %s, Model: %s, Price: %s", make, model, price);
    }
}
