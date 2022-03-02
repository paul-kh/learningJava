public class Main {
    public static void main(String[] args) {

        System.out.println("************ Method Hiding for static methods with the same name");
        System.out.println("************ Accessing static methods using class reference:");

        System.out.println("Property.getPropertyType(): " + Property.getPropertyType());
        System.out.println("ResidentialProperty.getPropertyType(): " + ResidentialProperty.getPropertyType());
        System.out.println("CommercialProperty.getPropertyType(): " + CommercialProperty.getPropertyType());


        ResidentialProperty residentialProperty1 = new ResidentialProperty("Residential property1", 500, ResidentialProperty.Type.CONDO, 500);
        CommercialProperty commercialProperty1 = new CommercialProperty("Commercial property1", 500, CommercialProperty.Type.OFFICE, 5000);
        // Creating a variable that hold type of 'Property' (base class) but get initialized by sub class 'ResidentialProperty
        Property residentialPropterty2 = new ResidentialProperty("Residential property2", 1600, ResidentialProperty.Type.SINGLE_FAMILY_HOME, 0);

        System.out.println("\n************ Accessing static methods using Object Reference:");


        // Java will promote all the object references below to be that classes of the types that those objects were declared
        System.out.println("residentialProperty1.getPropertyType(): " + residentialProperty1.getPropertyType()); // residentialProperty1 promoted to be the class "ResidentialProperty"
        System.out.println("commercialProperty1.getPropertyType(): " + commercialProperty1.getPropertyType()); // commercialProperty1 promoted to be the class "CommercialProperty"
        System.out.println("residentialPropterty2.getPropertyType(): " + residentialPropterty2.getPropertyType()); // residentialProperty2 promoted to be the base class "Property"
    }
}
