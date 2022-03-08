public class Main {
    public static void main(String[] args){

        Automobile huracan = new Lamborghini("Huracan", 78000.0);
        SportCar aventador = new Lamborghini("Aventador", 127000.0);

        System.out.println("Huracan: " + huracan);
        System.out.println("Aventador: " + aventador);

        System.out.println("\nHuracan is an instance of Lamborghini: " + (huracan instanceof Lamborghini));
        System.out.println("Huracan is an instance of SportCar: " + (huracan instanceof SportCar));
        System.out.println("Huracan is an instance of Automobile: " + (huracan instanceof Automobile));

        System.out.println("\nAventador is an instance of Lamborghini: " + (aventador instanceof Lamborghini));
        System.out.println("Aventador is an instance of SportCar: " + (aventador instanceof SportCar));
        System.out.println("Aventador is an instance of Automobile: " + (aventador instanceof Automobile));

    }
}
