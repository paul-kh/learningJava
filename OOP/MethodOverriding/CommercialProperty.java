public class CommercialProperty extends Property{

    public enum Type {
        OFFICE,
        RETAIL,
        INDUSTRIAL
    }

    private Type commercialPropertyType = Type.OFFICE;
    private float contractedServicesFees;

    public CommercialProperty(String projectName, int propertySize, Type commercialPropertyType, float contractedServicesFees){
        super("Commercial", projectName, propertySize);
        this.commercialPropertyType = commercialPropertyType;
        this.contractedServicesFees = contractedServicesFees;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.format("CommercialProperty {type: %s, contract services fees: %.1f}", commercialPropertyType, contractedServicesFees);
        System.out.println();

    }
}
