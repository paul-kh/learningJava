import java.util.HashMap;
import java.util.Map;

public class GenericMethod {

    public static void main(String[] args) {

        Map<Integer, String> studentNamesMap = new HashMap<>();

        Integer[] studentIds = new Integer[] {22, 33, 44, 55};
        String[] studentNames = new String[] {"Doris", "Donald", "Elise", "Eric"};

        MapHelper<Integer, String> mapHelper1 = new MapHelper<>();

        mapHelper1.addEntries(studentNamesMap, studentIds, studentNames);

        mapHelper1.printEntries(studentNamesMap);

        // Run

        Map<Integer, Double> studentScoresMap = new HashMap<>();

        Double[] studentScores = new Double[] {3.2, 2.8, 3.3, 3.8};

        MapHelper<Integer, Double> mapHelper2 = new MapHelper<>();

        mapHelper2.addEntries(studentScoresMap, studentIds, studentScores);

        mapHelper2.printEntries(studentScoresMap);

        // Run
    }
}

