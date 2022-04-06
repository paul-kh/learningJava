public class compareTo_method {

    public static void main(String[] args) {
        System.out.println("A compareTo B: " + ("A".compareTo("B"))); // returns negative (-1) => A comes before B
        System.out.println("A compareTo Z: " + ("A".compareTo("Z")));

        // Run

        System.out.println("B compareTo A: " + ("B".compareTo("A")));  // Returns positive (1) => B comes after A
        System.out.println("Z compareTo A: " + ("Z".compareTo("A")));

        // Run

        System.out.println("L compareTo L: " + ("L".compareTo("L")));
        System.out.println("X compareTo X: " + ("X".compareTo("X")));

        System.out.println("A compareTo a: " + ("A".compareTo("a")));
        System.out.println("b compareTo B: " + ("b".compareTo("B")));

    }
}
