public class CommercialProperty extends Property{

    public enum Type {
        OFFICE,
        RETAIL,
        INDUSTRIAL
    }

    private Type commercialPropertyType = Type.OFFICE;
    private float contractedServicesFees;

    public CommercialProperty(String projectName, int propertySize, Type commercialPropertyType, float contractedServicesFees){
        super(projectName, propertySize);
        this.commercialPropertyType = commercialPropertyType;
        this.contractedServicesFees = contractedServicesFees;
    }
    public static String getPropertyType() {
          return "Commercial";
    }

    @Override
    public String toString() {
        String baseString = super.toString();
        return String.format("%s, \nCommercialProperty (overriding toString method) {Type: %s, Contacted Services Fees: %.1f}", baseString, commercialPropertyType, contractedServicesFees);
    }
}
