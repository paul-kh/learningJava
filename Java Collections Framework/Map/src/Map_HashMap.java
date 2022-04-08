import java.util.HashMap;
import java.util.Map;

public class Map_HashMap {

    public static void main(String[] args) {

        // Using custom object as key of the map object
        Map<Movie, Float> moviesMap = new HashMap<>();

        System.out.println("**** Keys can be custom objects");

        moviesMap.put(new Movie("Titanic", "Leonardo DiCaprio"), 8.8f);
        moviesMap.put(new Movie("Back to the Future", "Michael J. Fox"), 8.3f);
        moviesMap.put(new Movie("The Godfather", "Al Pacino"), 9.3f);
        moviesMap.put(new Movie("Casablanca", "Humphrey Bogart"), 8.9f);

        // Looping the entries of the map object then display key and value of each entry
        for (Map.Entry<Movie, Float> entry : moviesMap.entrySet()) {
            System.out.format("Key: %s, Value: %.1f\n", entry.getKey(), entry.getValue());
        }

        System.out.println();


        System.out.println("**** Duplicate entries for the same movie");

        Movie anotherGodfather = new Movie("The Godfather", "Al Pacino");

        moviesMap.put(anotherGodfather, 5.4f); // This will override the existing identical entry

        for (Map.Entry<Movie, Float> entry : moviesMap.entrySet()) {
            System.out.format("Key: %s, Value: %.1f\n", entry.getKey(), entry.getValue());
        }

    }
}
