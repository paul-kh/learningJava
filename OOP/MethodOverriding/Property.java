public class Property {

    // NOTE: getters and setters are excluded for clarity
    // getters are ideally used if the member variable should be accessible to other code
    // setters are ideally used for member variable which can be updated

    private String propertyType = "unknown";

    private final String projectName;
    private final int propertySize;

    public Property(String propertyType, String projectName, int propertySize) {
        this.propertyType = propertyType;
        this.projectName = projectName;
        this.propertySize = propertySize;
    }

    public void printDetails() {
        System.out.format("Property {type: %s, projectName: %s, propertySize: %d}", propertyType, projectName, propertySize);
        System.out.println();
    }

}
