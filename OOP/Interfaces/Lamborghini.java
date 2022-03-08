public class Lamborghini implements SportCar {

    private String make;
    private String model;
    private Double price;

    public Lamborghini(String model, Double price) {
        this.make = "Lamborghini";
        this.model = model;
        this.price = price;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Make: %s, Model: %s, Price: %s", make, model,price);
    }
}
