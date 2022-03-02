public class Property {

    private final String projectName;
    private final int propertySize;

    public Property(String projectName, int propertySize) {
        this.projectName = projectName;
        this.propertySize = propertySize;
    }

    public static String getPropertyType() {
          return  "unknown";
    }

    @Override
    public String toString(){
        return String.format("Property (overriding toString method) {type: %s, projectName: %s, propertySize: %s", projectName,propertySize);
    }

}
