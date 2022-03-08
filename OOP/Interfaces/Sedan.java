public class Sedan implements Automobile {

    private String make = null;
    private String model = null;
    private Double price = null;

    public Sedan(String make, String model, Double price) {
        this.make = make;
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
        return String.format("Make: %s, Model: %s, Price: %s", make, model, price);
    }
}
