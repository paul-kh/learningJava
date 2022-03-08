public class Main {
    public static void main(String[] args){

        // Runtime polymorphism - it's highly recommended to make an instance variable
        // instantiated from a class that implements an interface to be of that interface
        // type, NOT of that class type
        Automobile sedan = new Sedan("Honda", "Civic", 21000.0);

        System.out.println("Sedan make: " + sedan.getMake());
        System.out.println("Sedan model: " + sedan.getModel());
        System.out.println("Sedan price: " + sedan.getPrice());

        System.out.println("sedan is an instance of Sedan: " + (sedan instanceof Sedan));
        System.out.println("sedan is an instance of Automobile: " + (sedan instanceof Automobile));
    }
}
